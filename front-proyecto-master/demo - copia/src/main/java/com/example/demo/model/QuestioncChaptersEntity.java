package com.example.demo.model;


import java.time.LocalDateTime;

public class QuestioncChaptersEntity {
    private Long id;
    private Long questionId;
    public QuestioncChaptersEntity(Long id, Long questionId, Long chapterId, LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id;
        this.questionId = questionId;
        this.chapterId = chapterId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    private Long chapterId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getQuestionId() {
        return questionId;
    }
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
    public Long getChapterId() {
        return chapterId;
    }
    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
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
}

