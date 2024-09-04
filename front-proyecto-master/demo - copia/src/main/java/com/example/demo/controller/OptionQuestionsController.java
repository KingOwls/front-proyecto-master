
package com.example.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.OptionQuestionsService;
import com.example.demo.model.OptionQuestionsEntity;
import java.util.List;

@RestController
@RequestMapping("/option-questions")
public class OptionQuestionsController {
    private final OptionQuestionsService optionQuestionsService;

    public OptionQuestionsController(OptionQuestionsService optionQuestionsService) {
        this.optionQuestionsService = optionQuestionsService;
    }

    @GetMapping
    public List<OptionQuestionsEntity> getAllOptionQuestions() {
        return optionQuestionsService.getAllOptionQuestions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OptionQuestionsEntity> getOptionQuestionsById(@PathVariable Long id) {
        return optionQuestionsService.getOptionQuestionsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OptionQuestionsEntity createOptionQuestions(@RequestBody OptionQuestionsEntity optionQuestions) {
        return optionQuestionsService.saveOptionQuestions(optionQuestions);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOptionQuestions(@PathVariable Long id) {
        optionQuestionsService.deleteOptionQuestions(id);
        return ResponseEntity.noContent().build();
    }
    // Definir atributos y métodos aquí
}
