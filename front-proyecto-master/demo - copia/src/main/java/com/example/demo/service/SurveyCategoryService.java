package com.example.demo.service;

import com.example.demo.model.SurveyCategoryEntity;
import java.util.List;
import java.util.Optional;

public interface SurveyCategoryService {
   List<SurveyCategoryEntity> findAll();
    Optional<SurveyCategoryEntity> findById(Long id);
    SurveyCategoryEntity save(SurveyCategoryEntity survey);
    Optional<SurveyCategoryEntity> update(Long id, SurveyCategoryEntity survey);
    Optional<SurveyCategoryEntity> delete(Long id);
}
