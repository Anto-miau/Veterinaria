package com.exampleveterinaria.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exampleveterinaria.veterinaria.model.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository <Contacto, Integer>{

}
