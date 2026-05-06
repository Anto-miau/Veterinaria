package com.exampleveterinaria.veterinaria.DTO;

import lombok.Data;

@Data
public class DuenoDTO {
    private Integer id;
    private String nombre;
    private String rut;
    private String telefono;
    private String correo;
    private String direccion;
    private String nombreComuna;
}
