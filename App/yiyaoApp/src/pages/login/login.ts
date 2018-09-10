import { Component } from '@angular/core';
import { IonicPage, NavController, ModalController,Platform } from 'ionic-angular';
import { TabsPage } from '../tabs/tabs';
import { Datas } from '../../providers/data'
import { RegisterPage } from '../register/register'

@IonicPage()
@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
})
export class LoginPage {
  name:string;
  pwd:string;
  toggle:any;
  err  = '';
  constructor(public navCtrl: NavController,public modalCtrl: ModalController,public dataService: Datas, public platform: Platform) {
  }
  
  ionViewDidLoad() {
    this.platform.ready().then(() => {
      this.dataService.getData('logo').then((value) => {
        var logodata:any = JSON.parse(value);
        if(logodata){
          this.toggle = logodata.toggle
        }else{
          this.toggle = false;
        }
        if(this.toggle){
          this.name=logodata.name;
          this.pwd=logodata.pwd;
        }
      });
    })
  }
  // 登陆事件
  logIn(username,password) {
    if (username.value.length == 0) {
      this.err  = '请输入账号';
    } else if (password.value.length == 0) {
      this.err  = "请输入密码";
    } else {
      this.dataService.setData('logo',{"name":username.value,"pwd":password.value,"toggle":this.toggle})
      this.navCtrl.setRoot(TabsPage);
    }
  }

  register(){
    this.navCtrl.push(RegisterPage)
  }
}
