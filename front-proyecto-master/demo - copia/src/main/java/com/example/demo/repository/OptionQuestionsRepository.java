package com.example.demo.repository;

import com.example.demo.model.OptionQuestionsEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface OptionQuestionsRepository extends CrudRepository<OptionQuestionsEntity, Long> {
    List<OptionQuestionsEntity> findAll(); 
}


