package com.example.demo.domain.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.persistence.model.Cuenta;

@Repository
public interface CuentaRepository extends CrudRepository<Cuenta, Long> {
    Optional<Cuenta> findByUsername(String username);
}