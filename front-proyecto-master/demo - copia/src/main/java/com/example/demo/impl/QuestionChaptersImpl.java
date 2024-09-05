package com.example.demo.impl;


import com.example.demo.model.QuestioncChaptersEntity;
import com.example.demo.repository.QuestionChaptersRepository;
import com.example.demo.service.QuestionChaptersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionChaptersImpl implements QuestionChaptersService {

    private final QuestionChaptersRepository repository;

    
    @Autowired
    public QuestionChaptersImpl(QuestionChaptersRepository repository) {
        this.repository = repository;
    }


    @Transactional
    @Override
	public QuestioncChaptersEntity save(QuestioncChaptersEntity questionChapters) {
		 return repository.save(questionChapters);
	}

    @Transactional
    @Override
	public Optional<QuestioncChaptersEntity> update(Long id, QuestioncChaptersEntity questionChapters) {
		  if (repository.existsById(id)) {
            questionChapters.setId(id);
            return Optional.of(repository.save(questionChapters));
        }
        return Optional.empty();
    }


    @Transactional
	@Override
	public List<QuestioncChaptersEntity> findAll() {
		return repository.findAll();
	}


	@Override
	public Optional<QuestioncChaptersEntity> findById(Long id) {
		return repository.findById(id);
	}


    @Transactional
	@Override
	public Optional<QuestioncChaptersEntity> delete(Long id) {
		Optional<QuestioncChaptersEntity> questionOpt = repository.findById(id);
        questionOpt.ifPresent(repository::delete);
        return questionOpt;
    }

}
