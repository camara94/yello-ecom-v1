import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ProductsComponent } from './products/products.component'
import { ProductSelectedComponent } from './product-selected/product-selected.component';

const routes: Routes = [
  { path: 'productsSelected', component: ProductSelectedComponent },
  { path: 'catalogue', component: ProductsComponent },
  { path: '', redirectTo: 'catalogue', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
