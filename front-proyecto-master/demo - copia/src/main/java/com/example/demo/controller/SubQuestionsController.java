package com.example.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.SubQuestionsService;
import com.example.demo.model.SubQuestionsEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sub-questions")
public class SubQuestionsController {

    private final SubQuestionsService subQuestionsService;

    public SubQuestionsController(SubQuestionsService subQuestionsService) {
        this.subQuestionsService = subQuestionsService;
    }

    @GetMapping
    public List<SubQuestionsEntity> getAllSubQuestions() {
        return subQuestionsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubQuestionsEntity> getSubQuestionsById(@PathVariable Long id) {
        return subQuestionsService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SubQuestionsEntity> createSubQuestions(@RequestBody SubQuestionsEntity subQuestions) {
        SubQuestionsEntity createdSubQuestion = subQuestionsService.save(subQuestions);
        return ResponseEntity.ok(createdSubQuestion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubQuestionsEntity> updateSubQuestions(@PathVariable Long id, @RequestBody SubQuestionsEntity subQuestions) {
        return subQuestionsService.update(id, subQuestions)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SubQuestionsEntity> eliminar(@PathVariable Long id) {
        Optional<SubQuestionsEntity> ciudadOpt = subQuestionsService.delete(id);
        if (ciudadOpt.isPresent()) {
            return ResponseEntity.ok(ciudadOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}

