package com.example.demo.service;

import com.example.demo.model.SubQuestionsEntity;
import java.util.List;
import java.util.Optional;

public interface SubQuestionsService {
    List<SubQuestionsEntity> findAll();
    Optional<SubQuestionsEntity> findById(Long id);
    SubQuestionsEntity save(SubQuestionsEntity subQuestions);
    Optional<SubQuestionsEntity> update(Long id, SubQuestionsEntity subQuestions);
    Optional<SubQuestionsEntity> delete(Long id);
}
