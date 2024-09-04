package com.example.demo.repository;


import com.example.demo.model.ChaptersEntity;
import org.springframework.data.repository.CrudRepository;

public interface ChapterRepository extends CrudRepository<ChaptersEntity, Long> {
}
