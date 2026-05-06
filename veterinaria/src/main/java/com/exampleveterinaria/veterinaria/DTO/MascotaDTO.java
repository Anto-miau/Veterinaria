package com.exampleveterinaria.veterinaria.DTO;

import lombok.Data;

@Data
public class MascotaDTO {
    private Integer id;
    private String nombre;
    private String color;
    private Integer edad;
    private String sexo;
    private String nombreDueno;
    private String nombreRaza;
}
