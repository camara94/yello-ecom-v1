package com.camaratek.ecommerce.web;

import com.camaratek.ecommerce.repositories.ProductJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.lang.Exception;
import com.camaratek.ecommerce.entities.Product;


@RestController
public class CatalogueRestController {
    @Autowired
    ProductJPARepository productJPARepository;
    //Autre façon de faire l'injection <==> à @Autowired
    /*public CatalogueRestController(ProductJPARepository productJPARepository) {
        this.productJPARepository = productJPARepository;
    }*/

    //pour récupérer la photo
    @GetMapping(path = "/photoProduct/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception {
        Product p = productJPARepository.findById(id).get();
        System.out.println( Files.readAllBytes( Paths.get( System.getProperty("user.home") + "/imagesmicros/products/" + p.getPhotoName() ) ) );
       return Files.readAllBytes( Paths.get( System.getProperty("user.home") + "/imagesmicros/products/" + p.getPhotoName() ) );
    }
}
