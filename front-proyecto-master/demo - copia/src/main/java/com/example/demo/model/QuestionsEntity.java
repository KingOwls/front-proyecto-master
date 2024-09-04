package com.example.demo.model;

import java.time.LocalDateTime;
import org.hibernate.internal.util.collections.ConcurrentReferenceHashMap.Option;
import java.util.List;

public class QuestionsEntity {
    
    private Long id;
    private String questionText;
    private String responseType;
    private String questionNumber;
    private String commentQuestion;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Option> options;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public QuestionsEntity(Long id, String questionText, String responseType, String questionNumber,
            String commentQuestion, LocalDateTime createdAt, LocalDateTime updatedAt, List<Option> options) {
        this.id = id;
        this.questionText = questionText;
        this.responseType = responseType;
        this.questionNumber = questionNumber;
        this.commentQuestion = commentQuestion;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.options = options;
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
    public List<Option> getOptions() {
        return options;
    }
    public void setOptions(List<Option> options) {
        this.options = options;
    }


}
