package com.example.demo.domain.service.QuestionChapters;

import com.example.demo.domain.repositories.QuestionChaptersRepository;
import com.example.demo.repository.entities.QuestionChaptersEntity;
import com.example.demo.repository.entities.QuestioncChaptersEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionChaptersImpl implements QuestionChaptersService {

    private final QuestionChaptersRepository repository;

    // Inyección de dependencia mediante constructor
    public QuestionChaptersImpl(QuestionChaptersRepository repository) {
        this.repository = repository;
    }

     @Override
    public List<QuestionChaptersEntity> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }


    @Transactional
    @Override
    public Optional<QuestionChaptersEntity> findById(Long id) {
        return Optional.empty();
    }

    @Transactional
    @Override
    public QuestionChaptersEntity save(QuestionChaptersEntity questionChapters) {
        return repository.save(questionChapters);
    }

    @Transactional
    @Override
    public Optional<QuestioncChaptersEntity> update(Long id, QuestionChaptersEntity questionChapters) {
        if (repository.existsById(id)) {
            // Convert QuestionChaptersEntity to QuestioncChaptersEntity if needed
            QuestioncChaptersEntity updatedEntity = convertToQuestioncChaptersEntity(questionChapters);
            return Optional.of(repository.save(updatedEntity));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<QuestioncChaptersEntity> delete(Long id) {
        Optional<QuestioncChaptersEntity> entityOpt = repository.findById(id);
        entityOpt.ifPresent(repository::delete);
        return entityOpt;
    }

    // Helper method to convert between entities if needed
    private QuestioncChaptersEntity convertToQuestioncChaptersEntity(QuestionChaptersEntity questionChapters) {
        // Implement conversion logic here
        return new QuestioncChaptersEntity(); // Replace with actual conversion logic
    }



   
}
