package com.example.demo.impl;


import com.example.demo.model.CategoryOptionsEntity;
import com.example.demo.repository.CategoryOptionsRepository;
import com.example.demo.service.CategoryOptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryOptionsImpl implements CategoryOptionsService {

    private final CategoryOptionsRepository repository;

    // Inyección de dependencias mediante el constructor
    @Autowired
    public CategoryOptionsImpl(CategoryOptionsRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public List<CategoryOptionsEntity> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Optional<CategoryOptionsEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public CategoryOptionsEntity save(CategoryOptionsEntity categoryOptions) {
        return repository.save(categoryOptions);
    }

    @Transactional
    @Override
    public Optional<CategoryOptionsEntity> update(Long id, CategoryOptionsEntity categoryOptions) {
        if (repository.existsById(id)) {
            categoryOptions.setId(id);
            return Optional.of(repository.save(categoryOptions));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<CategoryOptionsEntity> delete(Long id) {
        Optional<CategoryOptionsEntity> categoryOpt = repository.findById(id);
        categoryOpt.ifPresent(repository::delete);
        return categoryOpt;
    }
}
