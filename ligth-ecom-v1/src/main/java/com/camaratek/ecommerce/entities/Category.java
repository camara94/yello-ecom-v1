package com.camaratek.ecommerce.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Entity
public class Category implements Serializable {

    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String photo;
    @OneToMany( mappedBy = "category")
    private Collection<Product> produits;

    public Category() {}

    public Category(Long id, String name, String description, Collection<Product> produits) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.produits = produits;
    }

    public Category(Long id, String name, String description, String photo, Collection<Product> produits) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.produits = produits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Product> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Product> produits) {
        this.produits = produits;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

