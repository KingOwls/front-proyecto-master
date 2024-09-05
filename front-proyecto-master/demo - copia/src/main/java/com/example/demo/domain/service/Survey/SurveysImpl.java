
package com.example.demo.domain.service.Survey;

import com.example.demo.domain.repositories.SurveyRepository;
import com.example.demo.repository.entities.SurveyEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SurveysImpl implements SurveyService {

    private final SurveyRepository repository;

    // Inyección de dependencias a través del constructor
    @Autowired
    public SurveysImpl(SurveyRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public List<SurveyEntity> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Optional<SurveyEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public SurveyEntity save(SurveyEntity survey) {
        return repository.save(survey);
    }

    @Transactional
    @Override
    public Optional<SurveyEntity> update(Long id, SurveyEntity survey) {
        if (repository.existsById(id)) {
            survey.setId(id);
            return Optional.of(repository.save(survey));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<SurveyEntity> delete(Long id) {
        Optional<SurveyEntity> surveyOpt = repository.findById(id);
        surveyOpt.ifPresent(repository::delete);
        return surveyOpt;
    }
}
