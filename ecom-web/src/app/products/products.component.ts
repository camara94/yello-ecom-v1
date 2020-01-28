import { Component, OnInit } from '@angular/core';
import { CatalogueService } from './../catalogue.service'

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  private products;

       constructor(public catalogue: CatalogueService) { }
      ngOnInit () {
        this.getProducts();
      }

      private getProducts() {
         this.catalogue.getResource("/products")
                       .subscribe((data) => {
                       this.products = data; console.log(data);}, err =>{
                        console.error(err)
                       } );
      }

}
