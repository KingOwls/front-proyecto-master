package com.example.demo.service;


import org.springframework.stereotype.Service;

import com.example.demo.model.CategoryCatalogEntity;
import com.example.demo.repository.CategoryCatalogRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryCatalogService {

    private final CategoryCatalogRepository categoryCatalogRepository;

    public CategoryCatalogService(CategoryCatalogRepository categoryCatalogRepository) {
        this.categoryCatalogRepository = categoryCatalogRepository;
    }

    public List<CategoryCatalogEntity> getAllCategoryCatalogs() {
        return categoryCatalogRepository.findAll();
    }

    public Optional<CategoryCatalogEntity> getCategoryCatalogById(Long id) {
        return categoryCatalogRepository.findById(id);
    }

    public CategoryCatalogEntity saveCategoryCatalog(CategoryCatalogEntity categoryCatalog) {
        return categoryCatalogRepository.save(categoryCatalog);
    }

    public void deleteCategoryCatalog(Long id) {
        categoryCatalogRepository.deleteById(id);
    }
}

