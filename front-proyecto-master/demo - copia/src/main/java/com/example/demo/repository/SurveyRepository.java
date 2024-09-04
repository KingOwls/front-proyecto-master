package com.example.demo.repository;

import com.example.demo.model.SurveyEntity;
import org.springframework.data.repository.CrudRepository;


public interface SurveyRepository extends CrudRepository<SurveyEntity, Long> {
}
