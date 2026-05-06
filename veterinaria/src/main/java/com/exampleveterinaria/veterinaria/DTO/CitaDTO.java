package com.exampleveterinaria.veterinaria.DTO;

import java.time.LocalDateTime;

import com.exampleveterinaria.veterinaria.model.Mascota;

import lombok.Data;

@Data
public class CitaDTO {
    private Integer id;
    private String motivo;
    private LocalDateTime fechaHora;
    private String estado;
    private Mascota nombreMascota;
}
