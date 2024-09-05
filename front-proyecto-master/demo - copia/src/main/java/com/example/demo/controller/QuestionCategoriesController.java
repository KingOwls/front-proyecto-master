
package com.example.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.QuestionCategoriesEntity; // Asegúrate de que este sea el nombre correcto de la entidad
import com.example.demo.service.QuestionsCategoriesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questions-categories")
public class QuestionCategoriesController {

    private final QuestionsCategoriesService questionsCategoriesService;

    public QuestionCategoriesController(QuestionsCategoriesService questionsCategoriesService) {
        this.questionsCategoriesService = questionsCategoriesService;
    }

    @GetMapping
    public List<QuestionCategoriesEntity> getAllQuestionsCategories() {
        return questionsCategoriesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionCategoriesEntity> getQuestionsCategoriesById(@PathVariable Long id) {
        return questionsCategoriesService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<QuestionCategoriesEntity> createQuestionsCategories(@RequestBody QuestionCategoriesEntity questionsCategories) {
        QuestionCategoriesEntity createdCategory = questionsCategoriesService.save(questionsCategories);
        return ResponseEntity.ok(createdCategory); // Devuelve el objeto creado
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionCategoriesEntity> updateQuestionsCategories(@PathVariable Long id, @RequestBody QuestionCategoriesEntity questionsCategories) {
        return questionsCategoriesService.update(id, questionsCategories)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<QuestionCategoriesEntity> eliminar(@PathVariable Long id) {
        Optional<QuestionCategoriesEntity> ciudadOpt = questionsCategoriesService.delete(id);
        if (ciudadOpt.isPresent()) {
            return ResponseEntity.ok(ciudadOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
