package com.example.demo.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.repository.entities.SubQuestionsEntity;

import java.util.List;

public interface SubQuestionsRepository extends CrudRepository<SubQuestionsEntity, Long> {
    List<SubQuestionsEntity> findAll(); 
}
