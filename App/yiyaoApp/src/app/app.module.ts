import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { IonicStorageModule } from '@ionic/storage';
import { Network } from '@ionic-native/network';
import { AppVersion } from '@ionic-native/app-version';
import { HttpModule  } from '@angular/http';
import { Diagnostic } from '@ionic-native/diagnostic';
import { File } from '@ionic-native/file';
import { FileTransfer } from '@ionic-native/file-transfer';
import { FileOpener } from '@ionic-native/file-opener';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { LoginPage } from '../pages/login/login';
import { SettingPage } from '../pages/setting/setting';
import { TabsPage } from '../pages/tabs/tabs';

import {VgCoreModule} from 'videogular2/core';
import {VgControlsModule} from 'videogular2/controls';
import {VgOverlayPlayModule} from 'videogular2/overlay-play';
import {VgBufferingModule} from 'videogular2/buffering';

import { RegisterPage } from '../pages/register/register';

import { Datas } from '../providers/data';
import { NativeService } from '../providers/NativeService';
import { VersionService } from '../providers/VersionService';
import { HttpService } from '../providers/HttpService';
import { ListPage } from '../pages/list/list';


@NgModule({
  declarations: [
    MyApp,
    LoginPage,
    HomePage,
    SettingPage,
    TabsPage,
    RegisterPage,
    ListPage
  ],
  imports: [
    BrowserModule,
    VgCoreModule,
    VgControlsModule,
    VgOverlayPlayModule,
    VgBufferingModule,
    IonicModule.forRoot(MyApp),
    IonicStorageModule.forRoot({
      name: 'myApp',
      driverOrder: ['sqlite', 'indexeddb', 'websql']
    }),
    HttpModule
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    LoginPage,
    HomePage,
    SettingPage,
    TabsPage,
    RegisterPage,
    ListPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    Network,
    Datas,
    NativeService,
    VersionService,
    AppVersion,
    HttpService,
    Diagnostic,
    File,
    FileTransfer,
    FileOpener
  ]
})
export class AppModule {}
