package com.example.demo.repository;

import com.example.demo.model.SubQuestionsEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface SubQuestionsRepository extends CrudRepository<SubQuestionsEntity, Long> {
    List<SubQuestionsEntity> findAll(); 
}
