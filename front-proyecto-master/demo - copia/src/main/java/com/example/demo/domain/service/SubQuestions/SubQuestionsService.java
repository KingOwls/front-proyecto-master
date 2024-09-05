package com.example.demo.domain.service.SubQuestions;

import java.util.List;
import java.util.Optional;

import com.example.demo.repository.entities.SubQuestionsEntity;

public interface SubQuestionsService {
    List<SubQuestionsEntity> findAll();
    Optional<SubQuestionsEntity> findById(Long id);
    SubQuestionsEntity save(SubQuestionsEntity subQuestions);
    Optional<SubQuestionsEntity> update(Long id, SubQuestionsEntity subQuestions);
    Optional<SubQuestionsEntity> delete(Long id);
}
