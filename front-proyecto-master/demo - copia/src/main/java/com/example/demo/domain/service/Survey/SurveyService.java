package com.example.demo.domain.service.Survey;


import java.util.List;
import java.util.Optional;

import com.example.demo.repository.entities.SurveyEntity;

public interface SurveyService {
   List<SurveyEntity> findAll();
    Optional<SurveyEntity> findById(Long id);
    SurveyEntity save(SurveyEntity survey);
    Optional<SurveyEntity> update(Long id, SurveyEntity survey);
    Optional<SurveyEntity> delete (Long id);
}
