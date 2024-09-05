package com.example.demo.repository;

import  com.example.demo.model.SurveyCategoryEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface SurveyCategoryRepository extends CrudRepository<SurveyCategoryEntity, Long> {
    List<SurveyCategoryEntity> findAll();
}

