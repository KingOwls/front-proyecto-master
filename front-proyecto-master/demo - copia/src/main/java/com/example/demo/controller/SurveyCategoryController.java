package com.example.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.SurveyCa;
import com.example.demo.model.SurveyCategoryEntity;
import java.util.List;

@RestController
@RequestMapping("/survey-category")
public class SurveyCategoryController {
    private final SurveyCategoryService surveyCategoryService;

    public SurveyCategoryController(SurveyCategoryService surveyCategoryService) {
        this.surveyCategoryService = surveyCategoryService;
    }

    @GetMapping
    public List<SurveyCategoryEntity> getAllSurveyCategories() {
        return surveyCategoryService.getAllSurveyCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurveyCategoryEntity> getSurveyCategoryById(@PathVariable Long id) {
        return surveyCategoryService.getSurveyCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SurveyCategoryEntity createSurveyCategory(@RequestBody SurveyCategoryEntity surveyCategory) {
        return surveyCategoryService.saveSurveyCategory(surveyCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurveyCategory(@PathVariable Long id) {
        surveyCategoryService.deleteSurveyCategory(id);
        return ResponseEntity.noContent().build();
    }
}


