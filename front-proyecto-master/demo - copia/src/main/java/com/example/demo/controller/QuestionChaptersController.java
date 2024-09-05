package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.service.QuestionChapters.QuestionChaptersService;
import com.example.demo.repository.entities.QuestionChaptersEntity;
import com.example.demo.repository.entities.QuestioncChaptersEntity;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/question-chapters")
public class QuestionChaptersController {

    private final QuestionChaptersService service;

    public QuestionChaptersController(QuestionChaptersService service) {
        this.service = service;
    }

    @GetMapping
    public List<QuestionChaptersEntity> getAllQuestionsCategories() {
        return service.findAll();
    }

    public Optional<QuestionChaptersEntity> findById(Long id) {
        return service.findById(id);
    }


    @PostMapping
    public ResponseEntity<QuestionChaptersEntity> create(@RequestBody QuestionChaptersEntity questionsCategories) {
        QuestionChaptersEntity createdCategory = service.save(questionsCategories);
        return ResponseEntity.ok(createdCategory); // Devuelve el objeto creado
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestioncChaptersEntity> updateQuestionsCategories(@PathVariable Long id, @RequestBody QuestionChaptersEntity questionsCategories) {
        return service.update(id, questionsCategories)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<QuestionChaptersEntity> eliminar(@PathVariable Long id) {
        Optional<QuestionChaptersEntity> ciudadOpt = Optional.empty();
        if (ciudadOpt.isPresent()) {
            return ResponseEntity.ok(ciudadOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}

