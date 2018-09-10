import { Storage } from '@ionic/storage';
import { Component,Injectable } from '@angular/core';
@Injectable()
@Component({})
export class Datas {
    constructor(public storage: Storage) {
    }
    getData(key): Promise<any> {
        return this.storage.get(key);
    }
    setData(key,data): void {
        let newData = JSON.stringify(data);
        this.storage.set(key, newData);
    }
}