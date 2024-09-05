package com.example.demo.domain.repositories;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.repository.entities.ChaptersEntity;

public interface ChapterRepository extends CrudRepository<ChaptersEntity, Long> {
}
