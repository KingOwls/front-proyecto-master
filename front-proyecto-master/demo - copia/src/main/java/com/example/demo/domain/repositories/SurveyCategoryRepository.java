package com.example.demo.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.repository.entities.SurveyCategoryEntity;

import java.util.List;

public interface SurveyCategoryRepository extends CrudRepository<SurveyCategoryEntity, Long> {
    List<SurveyCategoryEntity> findAll();
}

