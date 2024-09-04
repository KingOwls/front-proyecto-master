package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.CategoryOptionsEntity;
import java.util.List;
import com.example.demo.service.CategoryOptionsService;
import java.util.Optional;

@RestController
@RequestMapping("/api/category-options")
public class CategoryOptionsController {

    private final CategoryOptionsEntity categoryOptionsService;

    @Autowired
    public CategoryOptionsController(CategoryOptionsService categoryOptionsService) {
        this.categoryOptionsService = categoryOptionsService;
    }

    @GetMapping
    public List<CategoryOptionsEntity> getAllCategoryOptions() {
        return categoryOptionsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryOptionsEntity> getCategoryOptionById(@PathVariable Long id) {
        Optional<CategoryOptionsEntity> categoryOption = categoryOptionsService.findById(id);
        return categoryOption.map(ResponseEntity::ok)
                             .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CategoryOptionsEntity createCategoryOption(@RequestBody CategoryOptionsEntity categoryOption) {
        return categoryOptionsService.save(categoryOption);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryOptionsEntity> updateCategoryOption(@PathVariable Long id, @RequestBody CategoryOptions categoryOption) {
        Optional<CategoryOptionsEntity> updatedCategoryOption = categoryOptionsService.update(id, categoryOption);
        return updatedCategoryOption.map(ResponseEntity::ok)
                                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryOption(@PathVariable Long id) {
        Optional<CategoryOptionsEntity> deletedCategoryOption = categoryOptionsService.delete(id);
        return deletedCategoryOption.isPresent() ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

