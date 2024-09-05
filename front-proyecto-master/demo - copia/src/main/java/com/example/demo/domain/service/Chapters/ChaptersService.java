package com.example.demo.domain.service.Chapters;

import java.util.List;
import java.util.Optional;

import com.example.demo.repository.entities.ChaptersEntity;

public interface ChaptersService {
    List<ChaptersEntity> findAll();
    Optional<ChaptersEntity> findById(Long id);
    ChaptersEntity save(ChaptersEntity chapter);
    Optional<ChaptersEntity> update(Long id, ChaptersEntity chapter);
    Optional<ChaptersEntity> delete(Long id);
}
