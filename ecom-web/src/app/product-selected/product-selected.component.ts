import { Component, OnInit } from '@angular/core';
import { CatalogueService } from './../catalogue.service'

@Component({
  selector: 'app-product-selected',
  templateUrl: './product-selected.component.html',
  styleUrls: ['./product-selected.component.css']
})
export class ProductSelectedComponent implements OnInit {
  private products;

         constructor(public catalogue: CatalogueService) { }
        ngOnInit () {
          this.getProducts();
        }

        private getProducts() {
           this.catalogue.getResource("/products/search/selectedProducts")
                         .subscribe((data) => {
                         this.products = data; console.log(data);}, err =>{
                          console.error(err)
                         } );
        }
}
