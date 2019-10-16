import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductComponent } from './product/product.component';
import { DetailsComponent } from './details/details.component';
import { BrandComponent } from './brand/brand.component';
import { ReviewsComponent } from './reviews/reviews.component';
import { AuthorComponent } from './reviews/author/author.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    DetailsComponent,
    BrandComponent,
    ReviewsComponent,
    AuthorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
