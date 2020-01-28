import { Component, OnInit } from '@angular/core';
import { CatalogueService } from './catalogue.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
   private categories;
    public host;
     constructor(public catalogue: CatalogueService) {

     }
    ngOnInit () {
      this.getCategories();
      this.host = "http://localhost:8080";
    }

    private getCategories() {
       this.catalogue.getResource("/categories")
                     .subscribe((data) => {
                     this.categories = data; console.log(this.categories)}, err =>{
                      console.error(err)
                     } );
    }
}
