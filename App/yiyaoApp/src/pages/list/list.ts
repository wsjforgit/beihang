import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { HttpService } from '../../providers/HttpService'


@IonicPage()
@Component({
  selector: 'page-list',
  templateUrl: 'list.html',
})
export class ListPage {
  title = '列表';
  datas = {};
  num: number = 0;
  constructor(public navCtrl: NavController, public navParams: NavParams,public Http:HttpService) {
    this.num = this.navParams.get('num');
    if(this.num==1){
      Http.Get('hospital/selectAll',true).then((d)=>{
        console.log(d)
        this.datas = JSON.parse(d.message);
      })
      this.datas=[]
      this.title = '合作医院';
    }else if(this.num==2){
      this.title = '信用中心';
      Http.Get('levelcenter/selectAll',true).then((d)=>{
        console.log(d.message)
        this.datas = JSON.parse(d.message);
      })
      this.datas=[]
    }else if(this.num==3){
      this.title = '医疗中心';
      Http.Get('medicalcenter/selectAll',true).then((d)=>{
        console.log(d.message)
        this.datas = JSON.parse(d.message);
      })
      this.datas=[]
    }else{
      this.title = '合作中心';
      Http.Get('cooperationcenter/selectAll',true).then((d)=>{
        console.log(d.message)
        this.datas = JSON.parse(d.message);
      })
      this.datas=[]
    }
    
  }

  ionViewDidLoad() {
    // console.log('ionViewDidLoad ListPage');
    
  }

}
