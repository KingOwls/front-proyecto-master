package com.example.demo.impl;


import com.example.demo.model.SurveyCategoryEntity;
import com.example.demo.repository.SurveyCategoryRepository;
import com.example.demo.service.SurveyCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

@Service
public class SurveyCategoryImpl implements SurveyCategoryService{

    private final SurveyCategoryRepository repository;

    @Autowired
    public SurveyCategoryImpl(SurveyCategoryRepository repository) {
        this.repository = repository;
    }


    @Transactional
    @Override
    public List<SurveyCategoryEntity> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Optional<SurveyCategoryEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public SurveyCategoryEntity save(SurveyCategoryEntity subQuestion) {
        return repository.save(subQuestion);
    }

    @Transactional
    @Override
    public Optional<SurveyCategoryEntity> update(Long id, SurveyCategoryEntity subQuestion) {
        if (repository.existsById(id)) {
            subQuestion.setId(id);
            return Optional.of(repository.save(subQuestion));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<SurveyCategoryEntity> delete(Long id) {
        Optional<SurveyCategoryEntity> subQuestionOpt = repository.findById(id);
        subQuestionOpt.ifPresent(repository::delete);
        return subQuestionOpt;
    }
}
