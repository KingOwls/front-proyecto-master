package com.example.demo.service;

import com.example.demo.model.OptionsEntity;
import java.util.List;
import java.util.Optional;

public interface OptionsService {
    List<OptionsEntity> findAll();
    Optional<OptionsEntity> findById(Long id);
    OptionsEntity save(OptionsEntity option);
    Optional<OptionsEntity> update(Long id, OptionsEntity option);
    Optional<OptionsEntity> delete(Long id);
}
