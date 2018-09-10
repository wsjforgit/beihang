import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { ListPage } from '../list/list';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html',
})

export class HomePage {

  constructor(public navCtrl: NavController, public statusBar: StatusBar) {
    statusBar.hide();
  }

  goPage(n){
    this.navCtrl.push(ListPage, {
      num : n
    });
  }
}