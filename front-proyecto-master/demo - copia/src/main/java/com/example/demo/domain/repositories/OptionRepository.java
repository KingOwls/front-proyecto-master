package com.example.demo.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.repository.entities.OptionsEntity;

import java.util.List;

public interface OptionRepository extends CrudRepository<OptionsEntity, Long> {
    List<OptionsEntity> findAll();
}

