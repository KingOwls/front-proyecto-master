
package com.example.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions-categories")
public class QuestionCategoriesController {
    private final QuestionsCategoriesService questionsCategoriesService;

    public QuestionsCategoriesController(QuestionsCategoriesService questionsCategoriesService) {
        this.questionsCategoriesService = questionsCategoriesService;
    }

    @GetMapping
    public List<QuestionsCategories> getAllQuestionsCategories() {
        return questionsCategoriesService.getAllQuestionsCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionsCategories> getQuestionsCategoriesById(@PathVariable Long id) {
        return questionsCategoriesService.getQuestionsCategoriesById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public QuestionsCategories createQuestionsCategories(@RequestBody QuestionsCategories questionsCategories) {
        return questionsCategoriesService.saveQuestionsCategories(questionsCategories);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestionsCategories(@PathVariable Long id) {
        questionsCategoriesService.deleteQuestionsCategories(id);
        return ResponseEntity.noContent().build();
    }
    // Definir atributos y métodos aquí
}
