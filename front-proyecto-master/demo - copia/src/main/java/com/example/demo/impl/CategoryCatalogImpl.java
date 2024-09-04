package com.example.demo.impl;




import com.example.demo.repository.CategoryCatalogRepository;
import com.example.demo.service.CategoriesCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryCatalogImpl implements CategoryCatalogService {

    private final CategoryCatalogRepository repository;

    @Autowired
    public CategoryCatalogServiceImpl(CategoryCatalogRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CategoryCatalog> findAll() {
        return (List<CategoryCatalog>) repository.findAll();
    }

    @Override
    public Optional<CategoryCatalog> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public CategoryCatalog save(CategoryCatalog categoryCatalog) {
        return repository.save(categoryCatalog);
    }

    @Override
    public Optional<CategoryCatalog> update(Long id, CategoryCatalog categoryCatalog) {
        if (repository.existsById(id)) {
            categoryCatalog.setId(id);
            return Optional.of(repository.save(categoryCatalog));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
