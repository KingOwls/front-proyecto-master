
package com.example.demo.model;

import java.time.LocalDateTime;


public class ChaptersEntity {
        private Long id;
    private String chapterNumber;
    private String chapterTitle;
    private String componentHtml;
    private String componentReact;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public Long getId() {
        return id;
    }
    public ChaptersEntity(Long id, String chapterNumber, String chapterTitle, String componentHtml,
            String componentReact, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.chapterNumber = chapterNumber;
        this.chapterTitle = chapterTitle;
        this.componentHtml = componentHtml;
        this.componentReact = componentReact;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getChapterNumber() {
        return chapterNumber;
    }
    public void setChapterNumber(String chapterNumber) {
        this.chapterNumber = chapterNumber;
    }
    public String getChapterTitle() {
        return chapterTitle;
    }
    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }
    public String getComponentHtml() {
        return componentHtml;
    }
    public void setComponentHtml(String componentHtml) {
        this.componentHtml = componentHtml;
    }
    public String getComponentReact() {
        return componentReact;
    }
    public void setComponentReact(String componentReact) {
        this.componentReact = componentReact;
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
