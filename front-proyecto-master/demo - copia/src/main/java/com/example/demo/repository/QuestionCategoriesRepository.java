package com.example.demo.repository;

import com.example.demo.model.QuestionCategoriesEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface QuestionCategoriesRepository extends CrudRepository<QuestionCategoriesEntity, Long> {
      List<QuestionCategoriesEntity> findAll();
    
}
