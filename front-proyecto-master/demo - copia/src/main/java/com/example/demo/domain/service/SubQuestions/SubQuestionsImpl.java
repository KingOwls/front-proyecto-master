package com.example.demo.domain.service.SubQuestions;

import com.example.demo.domain.repositories.SubQuestionsRepository;
import com.example.demo.repository.entities.SubQuestionsEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SubQuestionsImpl implements SubQuestionsService {

    private final SubQuestionsRepository repository;

    // Inyección de dependencias a través del constructor
    @Autowired
    public SubQuestionsImpl(SubQuestionsRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public List<SubQuestionsEntity> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Optional<SubQuestionsEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public SubQuestionsEntity save(SubQuestionsEntity subQuestion) {
        return repository.save(subQuestion);
    }

    @Transactional
    @Override
    public Optional<SubQuestionsEntity> update(Long id, SubQuestionsEntity subQuestion) {
        if (repository.existsById(id)) {
            subQuestion.setId(id);
            return Optional.of(repository.save(subQuestion));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<SubQuestionsEntity> delete(Long id) {
        Optional<SubQuestionsEntity> subQuestionOpt = repository.findById(id);
        subQuestionOpt.ifPresent(repository::delete);
        return subQuestionOpt;
    }
}
