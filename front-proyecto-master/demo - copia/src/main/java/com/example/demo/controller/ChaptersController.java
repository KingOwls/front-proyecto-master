package com.example.demo.controller;



import com.example.demo.model.*;
import com.example.demo.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import  com.example.demo.service.ChaptersService;
import com.example.demo.model.ChaptersEntity;
import java.util.List;

@RestController
@RequestMapping("/chapters")
public class ChaptersController {
    private final ChaptersService chapterService;

    public ChaptersController(ChaptersService chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping("/survey/{surveyId}")
    public List<ChaptersEntity> getChaptersBySurveyId(@PathVariable Long surveyId) {
        return chapterService.getChaptersBySurveyId(surveyId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChaptersEntity> getChapterById(@PathVariable Long id) {
        return chapterService.getChapterById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ChaptersEntity createChapter(@RequestBody ChaptersEntity chapter) {
        return chapterService.saveChapter(chapter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChapter(@PathVariable Long id) {
        chapterService.deleteChapter(id);
        return ResponseEntity.noContent().build();
    }// Definir atributos y métodos aquí
}
