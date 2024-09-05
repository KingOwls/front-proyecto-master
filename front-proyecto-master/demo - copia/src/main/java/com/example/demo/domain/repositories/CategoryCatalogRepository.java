package com.example.demo.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.repository.entities.CategoryCatalogEntity;

import java.util.List;


public interface CategoryCatalogRepository extends CrudRepository<CategoryCatalogEntity, Long> {
    List<CategoryCatalogEntity> findAll(); 
}
