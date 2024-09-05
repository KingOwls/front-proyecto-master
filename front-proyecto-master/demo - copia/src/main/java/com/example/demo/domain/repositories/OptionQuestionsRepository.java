package com.example.demo.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.repository.entities.OptionQuestionsEntity;

import java.util.List;


public interface OptionQuestionsRepository extends CrudRepository<OptionQuestionsEntity, Long> {
    List<OptionQuestionsEntity> findAll(); 
}


