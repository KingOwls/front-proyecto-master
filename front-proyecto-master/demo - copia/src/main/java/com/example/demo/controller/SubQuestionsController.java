package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.SubQuestionsService;
import com.example.demo.model.SubQuestionsEntity;
import java.util.List;

@RestController
@RequestMapping("/sub-questions")
public class SubQuestionsController {
    private final SubQuestionsService subQuestionsService;

    public SubQuestions(SubQuestionsService subQuestionsService) {
        this.subQuestionsService = subQuestionsService;
    }

    @GetMapping
    public List<SubQuestionsEntity> getAllSubQuestions() {
        return subQuestionsService.getAllSubQuestions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubQuestionsEntity> getSubQuestionsById(@PathVariable Long id) {
        return subQuestionsService.getSubQuestionsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SubQuestionsEntity createSubQuestions(@RequestBody SubQuestionsEntity subQuestions) {
        return subQuestionsService.saveSubQuestions(subQuestions);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubQuestions(@PathVariable Long id) {
        subQuestionsService.deleteSubQuestions(id);
        return ResponseEntity.noContent().build();
    }
    // Definir atributos y métodos aquí
}
