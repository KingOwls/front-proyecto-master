package com.example.demo.controller;

import com.example.demo.model.CategoryCatalogEntity;  // Asegúrate de usar la entidad correcta
import com.example.demo.service.CategoryCatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category-catalog")
public class CategoriesCatalogController {

    private final CategoryCatalogService service;

    public CategoriesCatalogController(CategoryCatalogService service) {
        this.service = service;
    }

    @GetMapping
    public List<CategoryCatalogEntity> getAllCategoryCatalogs() {
        return service.findAll();  // Asegúrate de usar el método correcto
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryCatalogEntity> getCategoryCatalogById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CategoryCatalogEntity createCategoryCatalog(@RequestBody CategoryCatalogEntity categoryCatalog) {
        return service.save(categoryCatalog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryCatalogEntity> updateCategoryCatalog(@PathVariable Long id, @RequestBody CategoryCatalogEntity categoryCatalog) {
        return service.update(id, categoryCatalog)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryCatalogEntity> eliminar(@PathVariable Long id) {
        Optional<CategoryCatalogEntity> ciudadOpt = service.deleteById(id);
        if (ciudadOpt.isPresent()) {
            return ResponseEntity.ok(ciudadOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
