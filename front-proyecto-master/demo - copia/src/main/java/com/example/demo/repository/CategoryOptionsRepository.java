package com.example.demo.repository;
import com.example.demo.model.CategoryOptionsEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface CategoryOptionsRepository extends CrudRepository<CategoryOptionsEntity, Long> {
    List<CategoryOptionsEntity> findAll(); 
}


