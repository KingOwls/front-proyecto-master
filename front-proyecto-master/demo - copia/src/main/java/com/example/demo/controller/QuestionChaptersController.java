package com.

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.QuestionChaptersService;
import com.example.demo.model.QuestionChapters;

import java.util.List;

@RestController
@RequestMapping("/question-chapters")
public class QuestionChaptersController {
    private final QuestionChaptersService questionChaptersService;

    public QuestionChaptersController(QuestionChaptersService questionChaptersService) {
        this.questionChaptersService = questionChaptersService;
    }

    @GetMapping
    public List<QuestionChapters> getAllQuestionChapters() {
        return questionChaptersService.getAllQuestionChapters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionChapters> getQuestionChaptersById(@PathVariable Long id) {
        return questionChaptersService.getQuestionChaptersById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public QuestionChapters createQuestionChapters(@RequestBody QuestionChapters questionChapters) {
        return questionChaptersService.saveQuestionChapters(questionChapters);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestionChapters(@PathVariable Long id) {
        questionChaptersService.deleteQuestionChapters(id);
        return ResponseEntity.noContent().build();
    }
}