package com.example.demo.service;


import com.example.demo.model.CategoryCatalogEntity;

import java.util.List;
import java.util.Optional;



public interface CategoryCatalogService {
    List<CategoryCatalogEntity> findAll();
    Optional<CategoryCatalogEntity> findById(Long id);
    CategoryCatalogEntity save(CategoryCatalogEntity categoryCatalog);
    Optional<CategoryCatalogEntity> update(Long id, CategoryCatalogEntity categoryCatalog);
    Optional<CategoryCatalogEntity> deleteById(Long id); 
}
