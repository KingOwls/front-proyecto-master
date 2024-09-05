package com.example.demo.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;

import java.util.List;

@Entity
@Table(name = "questions")
public class QuestionsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_text", nullable = false)
    private String questionText;

    @Column(name = "response_type", nullable = false)
    private String responseType;

    @Column(name = "question_number", nullable = false)
    private String questionNumber;

    @Column(name = "comment_question")
    private String commentQuestion;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OptionsEntity> options;

    // Constructor vacío
    public QuestionsEntity() {}

    // Constructor con parámetros
    public QuestionsEntity(Long id, String questionText, String responseType, String questionNumber,
                           String commentQuestion, LocalDateTime createdAt, LocalDateTime updatedAt, List<OptionsEntity> options) {
        this.id = id;
        this.questionText = questionText;
        this.responseType = responseType;
        this.questionNumber = questionNumber;
        this.commentQuestion = commentQuestion;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.options = options;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(String questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getCommentQuestion() {
        return commentQuestion;
    }

    public void setCommentQuestion(String commentQuestion) {
        this.commentQuestion = commentQuestion;
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

    public List<OptionsEntity> getOptions() {
        return options;
    }

    public void setOptions(List<OptionsEntity> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "QuestionsEntity{" +
                "id=" + id +
                ", questionText='" + questionText + '\'' +
                ", responseType='" + responseType + '\'' +
                ", questionNumber='" + questionNumber + '\'' +
                ", commentQuestion='" + commentQuestion + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", options=" + options +
                '}';
    }
}
