
package com.example.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.OptionQuestionsService;
import com.example.demo.model.OptionQuestionsEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/option-questions")
public class OptionQuestionsController {

    private final OptionQuestionsService optionQuestionsService;

    // Inyección de dependencia mediante constructor
    public OptionQuestionsController(OptionQuestionsService optionQuestionsService) {
        this.optionQuestionsService = optionQuestionsService;
    }

    @GetMapping
    public List<OptionQuestionsEntity> getAllOptionQuestions() {
        return optionQuestionsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OptionQuestionsEntity> getOptionQuestionsById(@PathVariable Long id) {
        return optionQuestionsService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OptionQuestionsEntity> createOptionQuestions(@RequestBody OptionQuestionsEntity optionQuestions) {
        OptionQuestionsEntity createdOptionQuestion = optionQuestionsService.save(optionQuestions);
        return ResponseEntity.ok(createdOptionQuestion); // Devuelve el objeto creado
    }

    @PutMapping("/{id}")
    public ResponseEntity<OptionQuestionsEntity> updateOptionQuestions(@PathVariable Long id, @RequestBody OptionQuestionsEntity optionQuestions) {
        return optionQuestionsService.update(id, optionQuestions)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OptionQuestionsEntity> eliminar(@PathVariable Long id) {
        Optional<OptionQuestionsEntity> ciudadOpt = optionQuestionsService.delete(id);
        if (ciudadOpt.isPresent()) {
            return ResponseEntity.ok(ciudadOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
