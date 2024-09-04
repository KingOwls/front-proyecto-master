package com.example.demo.service;


import com.example.demo.model.SurveyEntity;
import java.util.List;
import java.util.Optional;

public interface SurveyService {
   List<SurveyEntity> findAll();
    Optional<SurveyEntity> findById(Long id);
    SurveyEntity save(SurveyEntity survey);
    Optional<SurveyEntity> update(Long id, SurveyEntity survey);
    Optional<SurveyEntity> delete (Long id);
}
