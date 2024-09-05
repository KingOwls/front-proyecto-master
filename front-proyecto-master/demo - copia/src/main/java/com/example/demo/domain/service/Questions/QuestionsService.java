package com.example.demo.domain.service.Questions;

import java.util.List;
import java.util.Optional;

import com.example.demo.repository.entities.QuestionsEntity;

public interface QuestionsService {
    List<QuestionsEntity> findAll();
    Optional<QuestionsEntity> findById(Long id);
    QuestionsEntity save(QuestionsEntity question);
    Optional<QuestionsEntity> update(Long id, QuestionsEntity question);
    Optional<QuestionsEntity> delete(Long id);
}
