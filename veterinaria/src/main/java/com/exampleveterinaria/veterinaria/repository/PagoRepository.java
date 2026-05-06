package com.exampleveterinaria.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exampleveterinaria.veterinaria.model.Pago;

@Repository
public interface PagoRepository extends JpaRepository <Pago, Integer>{

}
