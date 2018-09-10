import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { LoginPage } from '../login/login';


@IonicPage()
@Component({
  selector: 'page-register',
  templateUrl: 'register.html',
})
export class RegisterPage {
  err  = '';

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    // console.log('ionViewDidLoad RegisterPage');
  }
  register(username,password,repassword){
    if (username.value.length == 0) {
      this.err  = '请输入账号';
    } else if (password.value.length == 0) {
      this.err  = "请输入密码";
    } else if (repassword.value.length == 0) {
      this.err  = "请再次输入密码";
    } else if (repassword.value != password.value) {
      this.err  = "两次密码不一致";
    } else {
      // this.dataService.setData('logo',{"name":username.value,"pwd":password.value,"toggle":this.toggle})
      this.navCtrl.setRoot(LoginPage);
    }
  }
}
