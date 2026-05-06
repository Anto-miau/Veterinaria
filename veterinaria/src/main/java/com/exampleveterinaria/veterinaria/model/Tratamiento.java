package com.exampleveterinaria.veterinaria.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tratamiento")
public class Tratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El diagnóstico es obligatorio")
    @Size(min = 5, max = 300, message = "El diagnóstico debe tener entre 5 y 300 caracteres")
    @Column(nullable = false, length = 300)
    private String diagnostico;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 5, max = 300, message = "La descripción debe tener entre 5 y 300 caracteres")
    @Column(nullable = false, length = 300)
    private String descripcion;

    @Column(nullable = false)
    private Date fechaInicio;

    @Column(nullable = false)
    private Date fechaTermino;
}
