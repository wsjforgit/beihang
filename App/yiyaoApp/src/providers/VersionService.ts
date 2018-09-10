import { Injectable } from '@angular/core';
import { NativeService } from '../providers/NativeService';
import { AlertController } from 'ionic-angular';
import { HttpService } from '../providers/HttpService';
import { File } from '@ionic-native/file';
import { FileTransfer, FileTransferObject } from '@ionic-native/file-transfer';
import { FileOpener } from '@ionic-native/file-opener';


@Injectable()
export class VersionService {
    appName; // 如app id为com.kit.ionic2tabs,则appName为ionic2tabs
    appType; // android 或 ios
    currentVersionNo; // 当前版本号
    latestVersionNo; // 最新版本号
    lastVersionInfo; // 从后台获取到的app最新版本信息
    versions; // app更新日志
    appDownloadPageUrl; // 下载页访问地址
    apkUrl; // android apk地址
    // app更新进度.默认为0,在app升级过程中会改变
    updateProgress = -1;
    constructor(private nativeService: NativeService, private alertCtrl: AlertController, 
        private httpService: HttpService,
        private file:File,
        public transfer: FileTransfer,
        public fileOpener: FileOpener) {

    }

    checkVersion(isManual = false) {
        if (!this.nativeService.isMobile()) {
            return;
        }
        // 获得app当前版本号
        this.nativeService.getVersionNumber().mergeMap(currentVersionNo => {
            this.currentVersionNo = currentVersionNo;
            // 获得app当前包名
            return this.nativeService.getPackageName();
        }).mergeMap(packageName => {
            this.appName = packageName.substring(packageName.lastIndexOf('.') + 1);
            this.appType = this.nativeService.isAndroid() ? 'android' : 'ios';
            const url = 'vs.json';
            // 从后台查询app最新版本信息
            return this.httpService.Get(url, true);
        }).subscribe(res => {
            // this.nativeService.alert(JSON.stringify(res))
            if (!res || res.code != 1) {
                console.log('从版本管理服务中获取版本信息失败');
                return;
            }
            if (res.code == 1 && res.data && !res.data.lastVersion) {
                console.log('从版本管理服务中未找到最新版本信息');
                return;
            }
            const data = res.data;
            this.lastVersionInfo = data.lastVersion;
            this.latestVersionNo = data.lastVersion.version;
            this.setApkDownloadUrl(data);

            if (this.latestVersionNo && (this.currentVersionNo == this.latestVersionNo)) {
                isManual && this.nativeService.alert('已经是最新版本');
                return;
            }

            const that = this;
            if (this.lastVersionInfo.isForcedUpdate == 1) { // 是否强制更新
                this.alertCtrl.create({
                    title: '重要升级',
                    subTitle: '您必须升级后才能使用！',
                    enableBackdropDismiss: false,
                    buttons: [{
                        text: '确定', handler: () => {
                            that.downloadApp();
                        }
                    }
                    ]
                }).present();
            } else {
                this.alertCtrl.create({
                    title: '升级',
                    subTitle: '发现新版本,是否立即升级？',
                    enableBackdropDismiss: false,
                    buttons: [{ text: '取消' }, {
                        text: '确定', handler: () => {
                            that.downloadApp();
                        }
                    }]
                }).present();
            }
        }, err => {
            // this.logger.log(err, '从版本管理服务中获取版本信息失败');
        });


    }

    /**
     * 下载app
     */
    downloadApp() {
        if (this.nativeService.isIos()) {// ios打开网页下载
            // this.nativeService.openUrlByBrowser(this.appDownloadPageUrl);
        }
        if (this.nativeService.isAndroid()) {// android本地下载
            if (!this.apkUrl) {
                this.nativeService.alert('未找到android apk下载地址');
                return;
            }
            this.nativeService.externalStoragePermissionsAuthorization().subscribe(() => {
                let backgroundProcess = false; // 是否后台下载
                let alert; // 显示下载进度
                if (this.lastVersionInfo.isForcedUpdate == 1) {// 如果是强制更新则没有后台下载按钮
                    alert = this.alertCtrl.create({
                        title: '下载进度：0%',
                        enableBackdropDismiss: false
                    });
                } else {
                    alert = this.alertCtrl.create({
                        title: '下载进度：0%',
                        enableBackdropDismiss: false,
                        buttons: [{
                            text: '后台下载', handler: () => {
                                backgroundProcess = true;
                            }
                        }]
                    });
                }
                alert.present();
                const fileTransfer: FileTransferObject = this.transfer.create();
                const apk = this.file.externalRootDirectory + 'Download/' + `android_${this.getSequence()}.apk`; // 下载apk保存的目录
                // 下载并安装apk
                fileTransfer.download(this.apkUrl, apk).then(() => {
                    alert && alert.dismiss();
                    this.fileOpener.open(apk, 'application/vnd.android.package-archive');
                }, err => {
                    this.updateProgress = -1;
                    alert && alert.dismiss();
                    // this.logger.log(err, 'android app 本地升级失败');
                    this.alertCtrl.create({
                        title: '前往网页下载',
                        subTitle: '本地升级失败',
                        buttons: [{
                            text: '确定', handler: () => {
                                this.nativeService.openUrlByBrowser(this.appDownloadPageUrl); // 打开网页下载
                            }
                        }
                        ]
                    }).present();
                });

                let timer = null; // 由于onProgress事件调用非常频繁,所以使用setTimeout用于函数节流
                fileTransfer.onProgress((event: ProgressEvent) => {
                    const progress = Math.floor(event.loaded / event.total * 100); // 下载进度
                    this.updateProgress = progress;
                    if (!timer) {
                        // 更新下载进度
                        timer = setTimeout(() => {
                            if (progress === 100) {
                                alert && alert.dismiss();
                            } else {
                                if (!backgroundProcess) {
                                    const title = document.getElementsByClassName('alert-title')[0];
                                    title && (title.innerHTML = `下载进度：${progress}%`);
                                }
                            }
                            clearTimeout(timer);
                            timer = null;
                        }, 1000);
                    }
                });
            });
        }
    }

    // 查询android apk下载地址
    setApkDownloadUrl(data) {
        this.apkUrl = "http://172.30.3.126/myapp.apk";
    }

    /**
     * 每次调用sequence加1
     * @type {()=>number}
     */
    getSequence = (() => {
        let sequence = 1;
        return () => {
        return ++sequence;
        };
    })();
}