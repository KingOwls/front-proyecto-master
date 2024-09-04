package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.controller.*;
import com.example.demo.service.QuestionsService;
import com.example.demo.model.QuestionsEntity;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionsController {
    public class Questions {
    private final QuestionsService questionService;

    public Questions(QuestionsService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/survey/{surveyId}")
    public List<QuestionsEntity> getQuestionsBySurveyId(@PathVariable Long surveyId) {
        return questionService.getQuestionsBySurveyId(surveyId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestQuestionsEntityion> getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public QuestionsEntity createQuestion(@RequestBody QuestionsEntity question) {
        return questionService.saveQuestion(question);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }
}
// Definir atributos y métodos aquí
}
