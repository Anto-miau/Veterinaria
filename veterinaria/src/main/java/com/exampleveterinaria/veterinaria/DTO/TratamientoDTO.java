package com.exampleveterinaria.veterinaria.DTO;

import java.util.Date;

import lombok.Data;

@Data
public class TratamientoDTO {
    private Integer id;
    private String diagnostico;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaTermino;
}
