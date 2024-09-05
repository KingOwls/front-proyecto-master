package com.example.demo.controller;

//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.service.OptionQuestions.OptionQuestionsService;
//import com.example.demo.persistence.model.OptionQuestionsEntity;

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
    public List<com.example.demo.repository.entities.OptionQuestionsEntity> getAllOptions() {
       return optionQuestionsService.findAll();  // Asegúrate de usar el método correcto
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.example.demo.repository.entities.OptionQuestionsEntity> getOptionById(@PathVariable Long id) {
        Optional<com.example.demo.repository.entities.OptionQuestionsEntity> option = optionQuestionsService.findById(id);
        return option.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

   
    // @PostMapping
    // public ResponseEntity<OptionQuestionsEntity> createOption(@RequestBody OptionQuestionsEntity option) {
    //     OptionQuestionsEntity createdOption = optionQuestionsService.save(option);
    //     return ResponseEntity.status(HttpStatus.CREATED).body(createdOption);
    // }

    // @PutMapping("/{id}")
    // public ResponseEntity<OptionQuestionsEntity> updateOption(@PathVariable Long id, @RequestBody OptionQuestionsEntity option) {
    //     Optional<OptionQuestionsEntity> updatedOption = optionQuestionsService.update(id, option);
    //     return updatedOption.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<com.example.demo.repository.entities.OptionQuestionsEntity> eliminar(@PathVariable Long id) {
        Optional<com.example.demo.repository.entities.OptionQuestionsEntity> ciudadOpt = optionQuestionsService.delete(id);
        if (ciudadOpt.isPresent()) {
            return ResponseEntity.ok(ciudadOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
