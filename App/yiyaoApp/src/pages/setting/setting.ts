import { Component } from '@angular/core';
import { IonicPage, App, NavController, NavParams,AlertController  } from 'ionic-angular';

import { LoginPage } from '../login/login';

@IonicPage()
@Component({
  selector: 'page-setting',
  templateUrl: 'setting.html',
})
export class SettingPage {

  constructor(public navCtrl: NavController, public navParams: NavParams,public appCtrl: App,public alertCtrl:AlertController ) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad SettingPage');
  }
  logout() {
    localStorage.clear();
    let alert = this.alertCtrl.create({
      title: '提示',
      subTitle: '你确定要注销账号吗？',
      buttons: [
        {
          text: '取消',
          role: 'cancel',
          handler: () => {
            // this.menuCtrl.close();
          }
        },
        {
          text: '确定',
          handler: () => {
            setTimeout(() => {
              this.appCtrl.getRootNavs()[0].setRoot(LoginPage);
            }, 500)
          }
        }
      ]
    });
    alert.present();
  }
}
