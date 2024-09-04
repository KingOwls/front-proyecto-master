package com.example.demo.service;

import com.example.demo.model.QuestionsEntity;
import java.util.List;
import java.util.Optional;

public interface QuestionsService {
    List<QuestionsEntity> findAll();
    Optional<QuestionsEntity> findById(Long id);
    QuestionsEntity save(QuestionsEntity question);
    Optional<QuestionsEntity> update(Long id, QuestionsEntity question);
    Optional<QuestionsEntity> delete(Long id);
}
