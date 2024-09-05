package com.example.demo.repository;

import com.example.demo.model.QuestioncChaptersEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface QuestionChaptersRepository extends CrudRepository<QuestioncChaptersEntity, Long> {
    List<QuestioncChaptersEntity> findAll();
}
