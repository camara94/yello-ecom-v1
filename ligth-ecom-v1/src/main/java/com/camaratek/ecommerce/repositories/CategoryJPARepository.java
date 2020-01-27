package com.camaratek.ecommerce.repositories;

import com.camaratek.ecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryJPARepository extends JpaRepository<Category, Long> {
}
