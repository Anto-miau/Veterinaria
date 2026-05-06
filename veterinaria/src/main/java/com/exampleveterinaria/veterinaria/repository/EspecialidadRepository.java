package com.exampleveterinaria.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exampleveterinaria.veterinaria.model.Especialidad;

@Repository
public interface EspecialidadRepository extends JpaRepository <Especialidad, Integer>{

}
