import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { LoadingController,Loading } from 'ionic-angular';

@Injectable()
export class HttpService {
    public loadingIsOpen:boolean = false;
    private loading: Loading;
    constructor(private http: Http, private loadingCtrl: LoadingController) {

    }
    public Get(uuid, showLoading) {
        if (showLoading) {
            this.showLoading('加载中...');
        }
        var url = "http://47.95.238.222/api/v1/" + uuid + "?"+Math.random();//显示loading此处是我们项目接口所需把本地app的信息包名传到接口
        return this.http.request(url).toPromise()
            .then(res => {
                if (this.loading) {
                    this.hideLoading();
                }
                return res.json();
            })
            .catch(err => {
                console.error(err)
            });
    }

    // post(data:string){
    //     let header=new Headers();                                                       //请求头 withCredentials:true表示允许跨域请求
    //     header.append("Access-Control-Allow-Origin", "*");
    //     header.append("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accipt");
    //     header.append('Content-Type', 'application/x-www-form-urlencoded');
    //     let option=new RequestOptions({headers:header,withCredentials:true});           //请求配置信息
    //     return this.http.post(this.url,data,option).timeout(this.TIMEOUT).map(res=>{    //post请求方法,格式基本上跨域固定这么写
    //       return res.json();                                                             //请求服务器数据返回
    //     });
    // }

    //显示loading
    showLoading(content: string = ''): void {
        if (!this.loadingIsOpen) {
            this.loadingIsOpen = true;
            this.loading = this.loadingCtrl.create({
                content: content
            });
            this.loading.present();
            setTimeout(() => { //显示loading最长显示10秒
                this.loadingIsOpen && this.loading.dismiss();
                this.loadingIsOpen = false;
            }, 10000);
        }
    };
    /**
    * 关闭loading
    */
    hideLoading(): void {
        this.loadingIsOpen && this.loading.dismiss();
        this.loadingIsOpen = false;
    };
}