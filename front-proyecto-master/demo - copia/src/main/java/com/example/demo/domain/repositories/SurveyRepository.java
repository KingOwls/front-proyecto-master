package com.example.demo.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.repository.entities.SurveyEntity;

import java.util.List;


public interface SurveyRepository extends CrudRepository<SurveyEntity, Long> {
    List<SurveyEntity> findAll();
}
