package com.example.demo.controller;


import com.example.demo.domain.service.CategoryCatalog.CategoryCatalogService;
import com.example.demo.repository.entities.CategoryCatalogEntity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category-catalog")
public class CategoryCatalogController {

    private final CategoryCatalogService categoryCatalogService;

    public CategoryCatalogController(CategoryCatalogService categoryCatalogService) {
        this.categoryCatalogService = categoryCatalogService;
    }

    @GetMapping
    public List<CategoryCatalogEntity> getAllCategoryCatalogs() {
        return categoryCatalogService.findAll();  // Asegúrate de usar el método correcto
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryCatalogEntity> getCategoryCatalogById(@PathVariable Long id) {
        return categoryCatalogService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CategoryCatalogEntity createCategoryCatalog(@RequestBody CategoryCatalogEntity categoryCatalog) {
        return categoryCatalogService.save(categoryCatalog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryCatalogEntity> updateCategoryCatalog(@PathVariable Long id, @RequestBody CategoryCatalogEntity categoryCatalog) {
        return categoryCatalogService.update(id, categoryCatalog)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryCatalogEntity> eliminar(@PathVariable Long id) {
        Optional<CategoryCatalogEntity> ciudadOpt = categoryCatalogService.deleteById(id);
        if (ciudadOpt.isPresent()) {
            return ResponseEntity.ok(ciudadOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
