package com.example.demo.domain.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.repository.entities.QuestionChaptersEntity;
import com.example.demo.repository.entities.QuestioncChaptersEntity;

import java.util.List;


public interface QuestionChaptersRepository extends JpaRepository<QuestioncChaptersEntity, Long> {
    List<QuestioncChaptersEntity> findAll();
    QuestionChaptersEntity save(QuestionChaptersEntity questionChapters);
}
