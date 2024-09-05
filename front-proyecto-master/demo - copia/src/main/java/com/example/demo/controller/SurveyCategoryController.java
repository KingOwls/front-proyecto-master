package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.service.SurveyCategory.SurveyCategoryService;
import com.example.demo.repository.entities.SurveyCategoryEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/survey-category")
public class SurveyCategoryController {

    private final SurveyCategoryService surveyCategoryService;

    public SurveyCategoryController(SurveyCategoryService surveyCategoryService) {
        this.surveyCategoryService = surveyCategoryService;
    }

    @GetMapping
    public List<SurveyCategoryEntity> getAllSurveyCategories() {
        return surveyCategoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurveyCategoryEntity> getSurveyCategoryById(@PathVariable Long id) {
        return surveyCategoryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SurveyCategoryEntity> createSurveyCategory(@RequestBody SurveyCategoryEntity surveyCategory) {
        SurveyCategoryEntity createdSurveyCategory = surveyCategoryService.save(surveyCategory);
        return ResponseEntity.ok(createdSurveyCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SurveyCategoryEntity> updateSurveyCategory(@PathVariable Long id, @RequestBody SurveyCategoryEntity surveyCategory) {
        return surveyCategoryService.update(id, surveyCategory)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<SurveyCategoryEntity> eliminar(@PathVariable Long id) {
        Optional<SurveyCategoryEntity> ciudadOpt = surveyCategoryService.delete(id);
        if (ciudadOpt.isPresent()) {
            return ResponseEntity.ok(ciudadOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}



