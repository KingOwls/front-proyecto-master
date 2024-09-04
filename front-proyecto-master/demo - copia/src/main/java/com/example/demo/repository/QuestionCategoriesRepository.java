package com.example.demo.repository;

import com.example.demo.model.QuestionCategoriesEntity;
import org.springframework.data.repository.CrudRepository;


public interface QuestionCategoriesRepository extends CrudRepository<QuestionCategoriesEntity, Long> {
    
}
