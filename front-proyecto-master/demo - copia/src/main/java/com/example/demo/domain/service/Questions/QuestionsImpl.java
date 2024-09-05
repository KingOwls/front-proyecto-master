
package com.example.demo.domain.service.Questions;

import com.example.demo.domain.repositories.QuestionRepository;
import com.example.demo.repository.entities.QuestionsEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionsImpl implements QuestionsService {

    private final QuestionRepository repository;

    // Inyección de dependencias a través del constructor
    @Autowired
    public QuestionsImpl(QuestionRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<QuestionsEntity> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Optional<QuestionsEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public QuestionsEntity save(QuestionsEntity question) {
        return repository.save(question);
    }

    @Transactional
    @Override
    public Optional<QuestionsEntity> update(Long id, QuestionsEntity question) {
        if (repository.existsById(id)) {
            question.setId(id);
            return Optional.of(repository.save(question));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<QuestionsEntity> delete(Long id) {
        Optional<QuestionsEntity> questionOpt = repository.findById(id);
        questionOpt.ifPresent(repository::delete);
        return questionOpt;
    }
}
