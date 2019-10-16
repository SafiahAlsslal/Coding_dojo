import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DetailsComponent } from './details/details.component';
import { ProductComponent } from './product/product.component';
import { BrandComponent } from "./brand/brand.component";
import { ReviewsComponent } from "./reviews/reviews.component";
import { AuthorComponent } from "./reviews/author/author.component";
const routes: Routes = [ 
  { path: 'products', component: ProductComponent,
   children:
   [ { path: 'details/:id', component: DetailsComponent } ,
    { path: 'brand/:brand', component: BrandComponent } ] } ,
    { path: 'reviews', component: ReviewsComponent,
    children:
    [ { path: 'author/:id', component: AuthorComponent },
    { path: 'details/:id', component: DetailsComponent } ] }
  
  ]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
