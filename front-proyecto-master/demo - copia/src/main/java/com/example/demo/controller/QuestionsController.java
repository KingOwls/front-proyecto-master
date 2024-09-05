package com.example.demo.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.service.Questions.QuestionsService;
import com.example.demo.repository.entities.QuestionsEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

    private final QuestionsService questionsService;

    public QuestionsController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

   @GetMapping
    public List<QuestionsEntity> getAllCategoryCatalogs() {
        return questionsService.findAll();  // Asegúrate de usar el método correcto
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionsEntity> getQuestionById(@PathVariable Long id) {
        return questionsService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<QuestionsEntity> createQuestion(@RequestBody QuestionsEntity question) {
        QuestionsEntity createdQuestion = questionsService.save(question);
        return ResponseEntity.ok(createdQuestion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionsEntity> updateQuestion(@PathVariable Long id, @RequestBody QuestionsEntity question) {
        return questionsService.update(id, question)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<QuestionsEntity> eliminar(@PathVariable Long id) {
        Optional<QuestionsEntity> ciudadOpt = questionsService.delete(id);
        if (ciudadOpt.isPresent()) {
            return ResponseEntity.ok(ciudadOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
