package com.exampleveterinaria.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exampleveterinaria.veterinaria.model.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository <Mascota, Integer>{

}
