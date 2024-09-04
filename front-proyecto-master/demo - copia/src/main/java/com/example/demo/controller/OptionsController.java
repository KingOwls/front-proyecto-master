package com.example.demo.controller;


import java.util.List;

import org.hibernate.internal.util.collections.ConcurrentReferenceHashMap.Option;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.OptionsService;



@RestController
@RequestMapping("/options")
public class OptionsController {private final OptionsService optionService;

    public OptionsController(OptionsService optionService) {
        this.optionService = optionService;
    }

    @GetMapping("/question/{questionId}")
    public List<Option> getOptionsByQuestionId(@PathVariable Long questionId) {
        return optionService.getOptionsByQuestionId(questionId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Option> getOptionById(@PathVariable Long id) {
        return optionService.getOptionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Option createOption(@RequestBody Option option) {
        return optionService.saveOption(option);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOption(@PathVariable Long id) {
        optionService.deleteOption(id);
        return ResponseEntity.noContent().build();
    }
    
  
}
