import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
id:number;
  constructor( private _route: ActivatedRoute,) { }
  ngOnInit() {
    this._route.params.subscribe((params: Params) => {
      this.id= params['id']
  });
  }

}
