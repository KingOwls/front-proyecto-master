package com.example.demo.domain.service.QuestionChapters;

import java.util.List;
import java.util.Optional;

import com.example.demo.repository.entities.QuestionChaptersEntity;
import com.example.demo.repository.entities.QuestioncChaptersEntity;

public interface QuestionChaptersService {
    List<QuestionChaptersEntity> findAll();
    Optional<QuestionChaptersEntity> findById(Long id);
    QuestionChaptersEntity save(QuestionChaptersEntity questionsCategories);
    Optional<QuestioncChaptersEntity> update(Long id, QuestionChaptersEntity questionsCategories);
    Optional<QuestioncChaptersEntity> delete(Long id);
}
