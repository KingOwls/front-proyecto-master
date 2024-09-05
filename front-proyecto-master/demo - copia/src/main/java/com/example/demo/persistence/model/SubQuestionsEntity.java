package com.example.demo.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "sub_questions")
public class SubQuestionsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sub_question_text", nullable = false)
    private String subQuestionText;

    @Column(name = "parent_question_id", nullable = false)
    private Long parentQuestionId;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // Constructor vacío
    public SubQuestionsEntity() {}

    // Constructor con parámetros
    public SubQuestionsEntity(Long id, String subQuestionText, Long parentQuestionId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.subQuestionText = subQuestionText;
        this.parentQuestionId = parentQuestionId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters y setters
    public Long getId() {
        return id;
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

    @Override
    public String toString() {
        return "SubQuestionsEntity{" +
                "id=" + id +
                ", subQuestionText='" + subQuestionText + '\'' +
                ", parentQuestionId=" + parentQuestionId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
