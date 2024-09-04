package com.example.demo.model;

import java.time.LocalDateTime;


public class OptionQuestionsEntity {
    private Long id;
    private String optionText;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public OptionQuestionsEntity(Long id, String optionText, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.optionText = optionText;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public String getOptionText() {
        return optionText;
    }
    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Constructores, getters y setters
    // Definir atributos y métodos aquí
}
