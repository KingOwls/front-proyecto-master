package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;



public class SurveyEntity {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<QuestionsEntity> questions;
    private List<ChaptersEntity> chapters;
    public Long getId() {
        return id;
    }
    public SurveyEntity(Long id, String name, String description, LocalDateTime createdAt, LocalDateTime updatedAt,
            List<QuestionsEntity> questions, List<ChaptersEntity> chapters) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.questions = questions;
        this.chapters = chapters;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
    public List<QuestionsEntity> getQuestions() {
        return questions;
    }
    public void setQuestions(List<QuestionsEntity> questions) {
        this.questions = questions;
    }
    public List<ChaptersEntity> getChapters() {
        return chapters;
    }
    public void setChapters(List<ChaptersEntity> chapters) {
        this.chapters = chapters;
    }

    // Constructores, getters y setters
}