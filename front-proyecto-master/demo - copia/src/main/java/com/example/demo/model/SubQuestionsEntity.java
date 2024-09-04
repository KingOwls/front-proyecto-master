package com.example.demo.model;



import java.time.LocalDateTime;

public class SubQuestionsEntity {
    private Long id;
    private String subQuestionText;
    private Long parentQuestionId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public Long getId() {
        return id;
    }
    public SubQuestionsEntity(Long id, String subQuestionText, Long parentQuestionId, LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id;
        this.subQuestionText = subQuestionText;
        this.parentQuestionId = parentQuestionId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSubQuestionText() {
        return subQuestionText;
    }
    public void setSubQuestionText(String subQuestionText) {
        this.subQuestionText = subQuestionText;
    }
    public Long getParentQuestionId() {
        return parentQuestionId;
    }
    public void setParentQuestionId(Long parentQuestionId) {
        this.parentQuestionId = parentQuestionId;
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

