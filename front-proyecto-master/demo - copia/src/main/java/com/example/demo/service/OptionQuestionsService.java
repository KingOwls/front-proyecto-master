package com.example.demo.service;

import com.example.demo.model.OptionQuestionsEntity;
import java.util.List;
import java.util.Optional;

public interface OptionQuestionsService {
    List<OptionQuestionsEntity> findAll();
    Optional<OptionQuestionsEntity> findById(Long id);
    OptionQuestionsEntity save(OptionQuestionsEntity optionQuestions);
    Optional<OptionQuestionsEntity> update(Long id, OptionQuestionsEntity optionQuestions);
    Optional<OptionQuestionsEntity> delete(Long id);
}
