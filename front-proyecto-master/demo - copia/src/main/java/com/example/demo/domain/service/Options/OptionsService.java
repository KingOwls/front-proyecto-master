package com.example.demo.domain.service.Options;

import java.util.List;
import java.util.Optional;

import com.example.demo.repository.entities.OptionsEntity;

public interface OptionsService {
    List<OptionsEntity> findAll();
    Optional<OptionsEntity> findById(Long id);
    OptionsEntity save(OptionsEntity option);
    Optional<OptionsEntity> update(Long id, OptionsEntity option);
    Optional<OptionsEntity> delete(Long id);
}
