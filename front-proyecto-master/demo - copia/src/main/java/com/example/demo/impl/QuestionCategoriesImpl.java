package com.example.demo.impl;


import com.example.demo.model.QuestionCategoriesEntity;
import com.example.demo.repository.QuestionCategoriesRepository;
import com.example.demo.service.QuestionsCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionCategoriesImpl implements QuestionsCategoriesService {

    private final QuestionCategoriesRepository repository;

    @Autowired
    public QuestionCategoriesImpl(QuestionCategoriesRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<QuestionCategoriesEntity> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Optional<QuestionCategoriesEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public QuestionCategoriesEntity save(QuestionCategoriesEntity questionCategories) {
        return repository.save(questionCategories);
    }

    @Transactional
    @Override
    public Optional<QuestionCategoriesEntity> update(Long id, QuestionCategoriesEntity questionCategories) {
        if (repository.existsById(id)) {
            questionCategories.setId(id);
            return Optional.of(repository.save(questionCategories));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<QuestionCategoriesEntity> delete(Long id) {
        Optional<QuestionCategoriesEntity> questionCategoriesOpt = repository.findById(id);
        questionCategoriesOpt.ifPresent(repository::delete);
        return questionCategoriesOpt;
    }
}
