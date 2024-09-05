package com.example.demo.controller;


import com.example.demo.domain.service.Chapters.ChaptersService;
import com.example.demo.repository.entities.ChaptersEntity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chapters")
public class ChaptersController {

    private final ChaptersService chapterService;

    // Inyección de dependencia mediante constructor
    public ChaptersController(ChaptersService chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping
    public List<ChaptersEntity> getAllCategoryCatalogs() {
        return chapterService.findAll();  // Asegúrate de usar el método correcto
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChaptersEntity> getChapterById(@PathVariable Long id) {
        return chapterService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ChaptersEntity> createChapter(@RequestBody ChaptersEntity chapter) {
        ChaptersEntity createdChapter = chapterService.save(chapter);
        return ResponseEntity.ok(createdChapter);  // Devuelve el capítulo creado
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChaptersEntity> updateChapter(@PathVariable Long id, @RequestBody ChaptersEntity chapter) {
        return chapterService.update(id, chapter)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChapter(@PathVariable Long id) {
        Optional<ChaptersEntity> deletedChapter = chapterService.delete(id);
        return deletedChapter.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
