package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.CategoriesCatalogService;
import com.example.demo.controller.CategoryCatalogController;
import com.example.demo.model.CategoriesCatalogEntity;
import java.util.List;

@RestController
@RequestMapping("/category-catalog")
public class CategoryCatalogController {
    private final CategoriesCatalogService categoryCatalogService;

    public CategoryCatalogController(CategoriesCatalogService categoryCatalogService) {
        this.categoryCatalogService = categoryCatalogService;
    }

    @GetMapping
    public List<CategoriesCatalogEntity> getAllCategoryCatalogs() {
        return categoryCatalogService.getAllCategoryCatalogs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriesCatalogEntity> getCategoryCatalogById(@PathVariable Long id) {
        return categoryCatalogService.getCategoryCatalogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CategoriesCatalogEntity createCategoryCatalog(@RequestBody CategoriesCatalogEntity categoryCatalog) {
        return categoryCatalogService.saveCategoryCatalog(categoryCatalog);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryCatalog(@PathVariable Long id) {
        categoryCatalogService.deleteCategoryCatalog(id);
        return ResponseEntity.noContent().build();
    }
}

