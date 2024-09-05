package com.example.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.OptionsEntity; // Asegúrate de que esta sea la entidad correcta
import com.example.demo.service.OptionsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/options")
public class OptionsController {

    private final OptionsService optionsService;

    public OptionsController(OptionsService optionsService) {
        this.optionsService = optionsService;
    }

    @GetMapping
    public List<OptionsEntity> getAllCategoryCatalogs() {
        return optionsService.findAll(); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<OptionsEntity> getOptionById(@PathVariable Long id) {
        return optionsService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OptionsEntity> createOption(@RequestBody OptionsEntity option) {
        OptionsEntity createdOption = optionsService.save(option);
        return ResponseEntity.ok(createdOption); // Devuelve el objeto creado
    }

    @PutMapping("/{id}")
    public ResponseEntity<OptionsEntity> updateOption(@PathVariable Long id, @RequestBody OptionsEntity option) {
        return optionsService.update(id, option)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OptionsEntity> eliminar(@PathVariable Long id) {
        Optional<OptionsEntity> ciudadOpt = optionsService.delete(id);
        if (ciudadOpt.isPresent()) {
            return ResponseEntity.ok(ciudadOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
