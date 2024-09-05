package com.example.demo.repository;

import com.example.demo.model.SurveyEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface SurveyRepository extends CrudRepository<SurveyEntity, Long> {
    List<SurveyEntity> findAll();
}
