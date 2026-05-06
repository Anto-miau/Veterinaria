package com.exampleveterinaria.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exampleveterinaria.veterinaria.model.Insumo;

@Repository
public interface InsumoRepository extends JpaRepository <Insumo, Integer>{

}
