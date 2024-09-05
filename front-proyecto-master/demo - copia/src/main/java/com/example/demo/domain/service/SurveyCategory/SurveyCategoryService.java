package com.example.demo.domain.service.SurveyCategory;

import java.util.List;
import java.util.Optional;

import com.example.demo.repository.entities.SurveyCategoryEntity;

public interface SurveyCategoryService {
   List<SurveyCategoryEntity> findAll();
    Optional<SurveyCategoryEntity> findById(Long id);
    SurveyCategoryEntity save(SurveyCategoryEntity survey);
    Optional<SurveyCategoryEntity> update(Long id, SurveyCategoryEntity survey);
    Optional<SurveyCategoryEntity> delete(Long id);
}
