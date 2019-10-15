import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  constructor(private _http: HttpClient){
    console.log("hi"); }

  getcakes(){
    return this._http.get('/cakes');
 }

 getOnecake(id) {
    return this._http.get('/cakes/'+id);
  }

  addcake(newcake){
    return this._http.post('/cake', newcake)
}

addrate(id_cake,rate){
  return this._http.post('/rate/'+id_cake,rate)
}


}
