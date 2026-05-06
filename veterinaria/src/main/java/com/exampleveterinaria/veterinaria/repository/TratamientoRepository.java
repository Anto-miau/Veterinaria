package com.exampleveterinaria.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exampleveterinaria.veterinaria.model.Tratamiento;

@Repository
public interface TratamientoRepository extends JpaRepository <Tratamiento, Integer>{

}
