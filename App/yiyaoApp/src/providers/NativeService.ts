import { Network } from '@ionic-native/network';
import { Injectable } from '@angular/core';
import { Platform, AlertController } from 'ionic-angular'
import { AppVersion } from '@ionic-native/app-version';
import { Observable } from 'rxjs/Rx';
import { Diagnostic } from '@ionic-native/diagnostic';

@Injectable()
export class NativeService {
    constructor(private platform: Platform, private network: Network,
        private appVersion: AppVersion,private alertCtrl:AlertController,
        private diagnostic: Diagnostic,) {

    }
    /**
     * 判断是否有网络
     */
    isConnecting(): boolean {
        return this.getNetworkType() != 'none';
    }
    /**
     * 获取网络类型 如`unknown`, `ethernet`, `wifi`, `2g`, `3g`, `4g`, `cellular`, `none`
     */
    getNetworkType(): string {
        if (!this.isMobile()) {
            return 'wifi';
        }
        return this.network.type;
    }

    /**
     * 是否真机环境
     */
    isMobile(): boolean {
        return this.platform.is('mobile') && !this.platform.is('mobileweb');
    }

    /**
     * 是否android真机环境
     */
    isAndroid(): boolean {
        return this.isMobile() && this.platform.is('android');
    }
  /**
   * 是否ios真机环境
   */
  isIos(): boolean {
    return this.isMobile() && (this.platform.is('ios') || this.platform.is('ipad') || this.platform.is('iphone'));
  }
  /**
   * 通过浏览器打开url
   */
  openUrlByBrowser(url: string): void {
    // this.inAppBrowser.create(url, '_system');
  }
  /**
   * 获得app版本号,如0.01
   * @description  对应/config.xml中version的值
   */
  getVersionNumber(): Observable<string> {
      return Observable.create(observer => {
        this.appVersion.getVersionNumber().then((value: string) => {
          observer.next(value);
        }).catch(err => {
          // this.logger.log(err, '获得app版本号失败');
          observer.error(false);
        });
      });
    }

  /**
   * 获得app包名/id,如com.kit.ionic2tabs
   * @description  对应/config.xml中id的值
   */
  getPackageName(): Observable<string> {
    return Observable.create(observer => {
      this.appVersion.getPackageName().then((value: string) => {
        observer.next(value);
      }).catch(err => {
        // this.logger.log(err, '获得app包名失败');
        observer.error(false);
      });
    });
  }
  /**
   * 只有一个确定按钮的弹出框.
   * 如果已经打开则不再打开
   */
  alert = (() => {
    let isExist = false;
    return (title: string, subTitle = '', message = '', callBackFun = null): void => {
      if (!isExist) {
        isExist = true;
        this.alertCtrl.create({
          title,
          subTitle,
          message,
          cssClass: 'alert-zIndex-highest',
          buttons: [{
            text: '确定', handler: () => {
              isExist = false;
              callBackFun && callBackFun();
            }
          }],
          enableBackdropDismiss: false
        }).present();
      }
    };
  })();

    /**
   * 检测app是否有读取存储权限,如果没有权限则会请求权限
   */
  externalStoragePermissionsAuthorization = (() => {
    let havePermission = false;
    return () => {
      return Observable.create(observer => {
        if (havePermission) {
          observer.next(true);
        } else {
          const permissions = [this.diagnostic.permission.READ_EXTERNAL_STORAGE, this.diagnostic.permission.WRITE_EXTERNAL_STORAGE];
          this.diagnostic.getPermissionsAuthorizationStatus(permissions).then(res => {
            if (res.READ_EXTERNAL_STORAGE == 'GRANTED' && res.WRITE_EXTERNAL_STORAGE == 'GRANTED') {
              havePermission = true;
              observer.next(true);
            } else {
              havePermission = false;
              this.diagnostic.requestRuntimePermissions(permissions).then(res => {// 请求权限
                if (res.READ_EXTERNAL_STORAGE == 'GRANTED' && res.WRITE_EXTERNAL_STORAGE == 'GRANTED') {
                  havePermission = true;
                  observer.next(true);
                } else {
                  havePermission = false;
                  this.alertCtrl.create({
                    title: '缺少读取存储权限',
                    subTitle: '请在手机设置或app权限管理中开启',
                    buttons: [{text: '取消'},
                      {
                        text: '去开启',
                        handler: () => {
                          this.diagnostic.switchToSettings();
                        }
                      }
                    ]
                  }).present();
                  observer.error(false);
                }
              }).catch(err => {
                // this.logger.log(err, '调用diagnostic.requestRuntimePermissions方法失败');
                observer.error(false);
              });
            }
          }).catch(err => {
            // this.logger.log(err, '调用diagnostic.getPermissionsAuthorizationStatus方法失败');
            observer.error(false);
          });
        }
      });
    };
  })();
}