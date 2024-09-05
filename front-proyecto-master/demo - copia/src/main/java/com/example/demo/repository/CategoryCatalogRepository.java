package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;


import com.example.demo.model.CategoryCatalogEntity;
import java.util.List;


public interface CategoryCatalogRepository extends CrudRepository<CategoryCatalogEntity, Long> {
    List<CategoryCatalogEntity> findAll(); 
}
