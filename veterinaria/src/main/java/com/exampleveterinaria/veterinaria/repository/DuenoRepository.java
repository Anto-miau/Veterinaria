package com.exampleveterinaria.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exampleveterinaria.veterinaria.model.Dueno;

@Repository
public interface DuenoRepository extends JpaRepository <Dueno, Integer>{

}
