package com.exampleveterinaria.veterinaria.DTO;

import lombok.Data;

@Data
public class InsumoDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer stock;
}
