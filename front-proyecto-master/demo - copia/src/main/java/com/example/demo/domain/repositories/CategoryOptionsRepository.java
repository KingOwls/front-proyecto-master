package com.example.demo.domain.repositories;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.repository.entities.CategoryOptionsEntity;

import java.util.List;


public interface CategoryOptionsRepository extends CrudRepository<CategoryOptionsEntity, Long> {
    List<CategoryOptionsEntity> findAll(); 
}


