package com.example.demo.domain.service.CategoryCatalog;


import java.util.List;
import java.util.Optional;

import com.example.demo.repository.entities.CategoryCatalogEntity;



public interface CategoryCatalogService {
    List<CategoryCatalogEntity> findAll();
    Optional<CategoryCatalogEntity> findById(Long id);
    CategoryCatalogEntity save(CategoryCatalogEntity categoryCatalog);
    Optional<CategoryCatalogEntity> update(Long id, CategoryCatalogEntity categoryCatalog);
    Optional<CategoryCatalogEntity> deleteById(Long id); 
}
