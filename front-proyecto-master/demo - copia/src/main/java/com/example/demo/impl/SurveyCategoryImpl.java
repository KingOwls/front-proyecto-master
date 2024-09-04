package com.example.demo.impl;


import com.example.demo.model.SurveyCategoryEntity;
import com.example.demo.repository.SurveyCategoryRepository;
import com.example.demo.service.SurveyCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyCategoryImpl {

    private final SurveyCategoryRepository surveyCategoryRepository;

    public SurveyCategoryService(SurveyCategoryService surveyCategoryService) {
        this.surveyCategoryRepository = surveyCategoryRepository;
    }

    public List<SurveyCategoryEntity> getAllSurveyCategories() {
        return surveyCategoryRepository.findAll();
    }

    public Optional<SurveyCategoryEntity> getSurveyCategoryById(Long id) {
        return surveyCategoryRepository.findById(id);
    }

    public SurveyCategoryEntity saveSurveyCategory(SurveyCategoryEntity surveyCategory) {
        return surveyCategoryRepository.save(surveyCategory);
    }

    public void deleteSurveyCategory(Long id) {
        surveyCategoryRepository.deleteById(id);
    }
}

