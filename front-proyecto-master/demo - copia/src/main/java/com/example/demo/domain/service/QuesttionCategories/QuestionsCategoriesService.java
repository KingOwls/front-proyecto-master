package com.example.demo.domain.service.QuesttionCategories;


import java.util.List;
import java.util.Optional;

import com.example.demo.repository.entities.QuestionCategoriesEntity;

public interface QuestionsCategoriesService {
    List<QuestionCategoriesEntity> findAll();
    Optional<QuestionCategoriesEntity> findById(Long id);
    QuestionCategoriesEntity save(QuestionCategoriesEntity questionCategories);
    Optional<QuestionCategoriesEntity> update(Long id, QuestionCategoriesEntity questionCategories);
    Optional<QuestionCategoriesEntity> delete(Long id);
}
