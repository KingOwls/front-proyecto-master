package com.example.demo.repository;

import com.example.demo.model.OptionsEntity;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface OptionRepository extends CrudRepository<OptionsEntity, Long> {
    List<OptionsEntity> findAll();
}
