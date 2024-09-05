package com.example.demo.domain.service.CategoryOption;

import java.util.List;
import java.util.Optional;

import com.example.demo.repository.entities.CategoryOptionsEntity;

public interface CategoryOptionsService {
    List<CategoryOptionsEntity> findAll();
    Optional<CategoryOptionsEntity> findById(Long id);
    CategoryOptionsEntity save(CategoryOptionsEntity categoryOptions);
    Optional<CategoryOptionsEntity> update(Long id, CategoryOptionsEntity categoryOptions);
    Optional<CategoryOptionsEntity> delete(Long id);
}
