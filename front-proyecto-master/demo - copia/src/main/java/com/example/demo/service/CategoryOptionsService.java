package com.example.demo.service;

import com.example.demo.model.CategoryOptionsEntity;
import java.util.List;
import java.util.Optional;

public interface CategoryOptionsService {
    List<CategoryOptionsEntity> findAll();
    Optional<CategoryOptionsEntity> findById(Long id);
    CategoryOptionsEntity save(CategoryOptionsEntity categoryOptions);
    Optional<CategoryOptionsEntity> update(Long id, CategoryOptionsEntity categoryOptions);
    Optional<CategoryOptionsEntity> delete(Long id);
}
