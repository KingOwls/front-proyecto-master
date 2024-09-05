package com.example.demo.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.repository.entities.QuestionsEntity;

import java.util.List;

public interface QuestionRepository extends CrudRepository<QuestionsEntity, Long> {
    List<QuestionsEntity> findAll();
}

