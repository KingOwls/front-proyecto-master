package com.example.demo.domain.service.OptionQuestions;

import java.util.List;
import java.util.Optional;

import com.example.demo.repository.entities.OptionQuestionsEntity;

public interface OptionQuestionsService {
    List<OptionQuestionsEntity> findAll();
    Optional<OptionQuestionsEntity> findById(Long id);
    OptionQuestionsEntity save(OptionQuestionsEntity optionQuestions);
    Optional<OptionQuestionsEntity> update(Long id, OptionQuestionsEntity optionQuestions);  
    Optional<OptionQuestionsEntity> delete(Long id);
}
