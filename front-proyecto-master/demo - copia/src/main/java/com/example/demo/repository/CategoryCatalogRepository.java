package com.example.demo.repository;

import com.example.demo.model.CategoryOptionsEntity;
import org.springframework.data.repository.CrudRepository;


public interface CategoryCatalogRepository extends CrudRepository<CategoryOptionsEntity, Long> {
}
