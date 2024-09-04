package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.CategoriesCatalogService;
import com.example.demo.model.CategoryOptionsEntity;
import java.util.List;

@RestController
@RequestMapping("/category-catalog")
public class CategoriesCatalogController {

    private final CategoriesCatalogService categoryCatalogService;

    public CategoriesCatalogController(CategoriesCatalogService categoryCatalogService) {
        this.categoryCatalogService = categoryCatalogService;
    }

    @GetMapping
    public List<CategoryOptionsEntity> getAllCategoryCatalogs() {
        return categoryCatalogService.getAllCategoryCatalogs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryOptionsEntity> getCategoryCatalogById(@PathVariable Long id) {
        return categoryCatalogService.getCategoryCatalogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CategoryOptionsEntity createCategoryCatalog(@RequestBody CategoryOptionsEntity categoryCatalog) {
        return categoryCatalogService.saveCategoryCatalog(categoryCatalog);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryCatalog(@PathVariable Long id) {
        categoryCatalogService.deleteCategoryCatalog(id);
        return ResponseEntity.noContent().build();
    }
}
