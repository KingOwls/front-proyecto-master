package com.example.demo.impl;

import com.example.demo.repository.CategoryCatalogRepository;
import com.example.demo.service.CategoryCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.CategoryCatalogEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryCatalogImpl implements CategoryCatalogService {

    private final CategoryCatalogRepository repository;


    @Autowired
    public CategoryCatalogImpl(CategoryCatalogRepository repository) {
        this.repository = repository;
    }

    @Transactional 
    @Override
    public List<CategoryCatalogEntity> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Optional<CategoryCatalogEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public CategoryCatalogEntity save(CategoryCatalogEntity categoryCatalog) {
        return repository.save(categoryCatalog);
    }

    @Transactional
    @Override
    public Optional<CategoryCatalogEntity> update(Long id, CategoryCatalogEntity categoryCatalog) {
        if (repository.existsById(id)) {
            categoryCatalog.setId(id); 
            return Optional.of(repository.save(categoryCatalog));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<CategoryCatalogEntity> deleteById(Long id) {
          Optional<CategoryCatalogEntity> chapterOpt = repository.findById(id);
        chapterOpt.ifPresent(chapterItem ->{
            repository.delete(chapterItem);
        });
        return chapterOpt;
    }
}

