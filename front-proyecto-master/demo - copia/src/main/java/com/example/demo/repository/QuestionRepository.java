package com.example.demo.repository;

import com.example.demo.model.QuestionsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<QuestionsEntity, Long> {
    List<QuestionsEntity> findAll();
}

