package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.SurveyService;
import com.example.demo.model.SurveyEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/surveys")
public class SurveysController {
    private final SurveyService surveyService;

    public SurveysController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping
    public List<SurveyEntity> getAllSurveys() {
        return surveyService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurveyEntity> getSurveyById(@PathVariable Long id) {
        return surveyService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SurveyEntity> createSurvey(@RequestBody SurveyEntity survey) {
        SurveyEntity createdSurvey = surveyService.save(survey);
        return ResponseEntity.ok(createdSurvey);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SurveyEntity> updateSurvey(@PathVariable Long id, @RequestBody SurveyEntity survey) {
        return surveyService.update(id, survey)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SurveyEntity> eliminar(@PathVariable Long id) {
        Optional<SurveyEntity> ciudadOpt = surveyService.delete(id);
        if (ciudadOpt.isPresent()) {
            return ResponseEntity.ok(ciudadOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
