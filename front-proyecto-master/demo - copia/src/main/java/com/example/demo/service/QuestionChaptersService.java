package com.example.demo.service;

import com.example.demo.model.QuestioncChaptersEntity;
import java.util.List;
import java.util.Optional;

public interface QuestionChaptersService {
    List<QuestioncChaptersEntity> findAll();
    Optional<QuestioncChaptersEntity> findById(Long id);
    QuestioncChaptersEntity save(QuestioncChaptersEntity questionChapters);
    Optional<QuestioncChaptersEntity> update(Long id, QuestioncChaptersEntity questionChapters);
    Optional<QuestioncChaptersEntity> delete(Long id);
}
