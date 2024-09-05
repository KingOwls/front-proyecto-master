package com.example.demo.domain.service.OptionQuestions;

import com.example.demo.domain.repositories.OptionQuestionsRepository;
import com.example.demo.repository.entities.OptionQuestionsEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OptionQuestionsImpl implements OptionQuestionsService {

    private final OptionQuestionsRepository repository;

    // Inyección de dependencias a través del constructor
    public OptionQuestionsImpl(OptionQuestionsRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public List<OptionQuestionsEntity> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Optional<OptionQuestionsEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public OptionQuestionsEntity save(OptionQuestionsEntity optionQuestions) {
        return repository.save(optionQuestions);
    }

    @Transactional
    @Override
    public Optional<OptionQuestionsEntity> update(Long id, OptionQuestionsEntity optionQuestions) {
        if (repository.existsById(id)) {
            optionQuestions.setId(id);
            return Optional.of(repository.save(optionQuestions));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<OptionQuestionsEntity> delete(Long id) {
        Optional<OptionQuestionsEntity> optionQuestionsOpt = repository.findById(id);
        optionQuestionsOpt.ifPresent(repository::delete);
        return optionQuestionsOpt;
    }
}

