import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CatalogueService } from './catalogue.service';
import { ProductsComponent } from './products/products.component';
import { ProductSelectedComponent } from './product-selected/product-selected.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    ProductSelectedComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    HttpClientModule,
    CatalogueService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
