package com.example.demo.service;

import com.example.demo.model.ChaptersEntity;
import java.util.List;
import java.util.Optional;

public interface ChaptersService {
    List<ChaptersEntity> findAll();
    Optional<ChaptersEntity> findById(Long id);
    ChaptersEntity save(ChaptersEntity chapter);
    Optional<ChaptersEntity> update(Long id, ChaptersEntity chapter);
    Optional<ChaptersEntity> delete(Long id);
}
