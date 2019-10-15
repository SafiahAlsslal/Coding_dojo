import { Component, OnInit  } from '@angular/core';
import { HttpService } from './http.service';
// import { task } from '/';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  cakes= [];
  cake=[]
  id=""
  cakeinfo : any
  edited : boolean;
  newcake: any;
  newrate: any;
  constructor(private _httpService: HttpService){ }
  ngOnInit(){
    this.AllCake()
    this.newcake = { name: "", url:"" } 
    this.newrate= { rating : 0 , comment:""}
    this.id=""
    this.edited = false;
    this.cakeinfo={}
  }
AllCake(): void{
  console.log(`Click event is working`);
    let observable = this._httpService.getcakes();
    observable.subscribe(data => {
       console.log("Got our cakes!", data)
       this.cakes = data['data'];
    });
  }

  addRate(cake_id ) :void {
    console.log(cake_id)
    let observable = this._httpService.addrate(cake_id,this.newrate);
    observable.subscribe(data => {
      console.log("rate added sccufully!", data)
   });
   this.newrate= { rating : 0 , comment:""}
   if (this.edited==true){
    this.showcake(cake_id)
   }
    
  }

  showcake(id): void{
  this.edited = true
  this.id=id
  let counter = 0;
  let sum = 0;
  let observable = this._httpService.getOnecake(this.id);
  observable.subscribe((data:any) => {
     console.log("Gotcake!!!!!", data)
     this.cakeinfo=data
     if (data.rating.length != 0) {
      for (let r of data.rating) {
        counter++;
        sum += parseInt(r.rating);
      }
      this.cakeinfo['average'] = (sum / counter).toFixed(2);
    } else {
      this.cakeinfo['average'] = "not rated!";
    }
  });   
    }

onSubmit() {
  let observable = this._httpService.addcake(this.newcake);
  observable.subscribe(data => {
    console.log("added sccufully!", data)
 });
  this.newcake = { name: "", url:"" } 
  this.AllCake()
}
}
