package com.example.demo.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Table(name = "chapters")
public class ChaptersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chapter_number", nullable = false, length = 10)
    private String chapterNumber;

    @Column(name = "chapter_title", nullable = false, length = 255)
    private String chapterTitle;

    @Column(name = "component_html", columnDefinition = "TEXT")
    private String componentHtml;

    @Column(name = "component_react", columnDefinition = "TEXT")
    private String componentReact;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // Constructor vacío
    public ChaptersEntity() {}

    // Constructor con parámetros
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

    // Getters y setters
    public Long getId() {
        return id;
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

    // Se ejecuta antes de insertar
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    // Se ejecuta antes de actualizar
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ChaptersEntity{" +
                "id=" + id +
                ", chapterNumber='" + chapterNumber + '\'' +
                ", chapterTitle='" + chapterTitle + '\'' +
                ", componentHtml='" + componentHtml + '\'' +
                ", componentReact='" + componentReact + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
