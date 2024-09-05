package com.example.demo.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.repository.entities.QuestionCategoriesEntity;

import java.util.List;


public interface QuestionCategoriesRepository extends CrudRepository<QuestionCategoriesEntity, Long> {
      List<QuestionCategoriesEntity> findAll();
    
}
