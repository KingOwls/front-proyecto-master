package com.example.demo.service;


import com.example.demo.model.QuestionCategoriesEntity;
import java.util.List;
import java.util.Optional;

public interface QuestionsCategoriesService {
    List<QuestionCategoriesEntity> findAll();
    Optional<QuestionCategoriesEntity> findById(Long id);
    QuestionCategoriesEntity save(QuestionCategoriesEntity questionCategories);
    Optional<QuestionCategoriesEntity> update(Long id, QuestionCategoriesEntity questionCategories);
    Optional<QuestionCategoriesEntity> delete(Long id);
}
