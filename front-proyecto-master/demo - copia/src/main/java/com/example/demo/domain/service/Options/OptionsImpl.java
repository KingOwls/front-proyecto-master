package com.example.demo.domain.service.Options;


import com.example.demo.domain.repositories.OptionRepository;
import com.example.demo.repository.entities.OptionsEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OptionsImpl implements OptionsService {

    private final OptionRepository repository;

    
    @Autowired
    public OptionsImpl(OptionRepository repository) {
        this.repository = repository;
    }

    @Transactional 
    @Override
    public List<OptionsEntity> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Optional<OptionsEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public OptionsEntity save(OptionsEntity options) {
        return repository.save(options);
    }

    @Transactional
    @Override
    public Optional<OptionsEntity> update(Long id, OptionsEntity options) {
        if (repository.existsById(id)) {
            options.setId(id);
            return Optional.of(repository.save(options));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<OptionsEntity> delete(Long id) {
        Optional<OptionsEntity> optionsOpt = repository.findById(id);
        optionsOpt.ifPresent(repository::delete);
        return optionsOpt;
    }
}
