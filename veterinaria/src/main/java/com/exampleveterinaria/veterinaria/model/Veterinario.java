package com.exampleveterinaria.veterinaria.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "veterinario")
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El rut es obligatorio")
    @Column(nullable = false, length = 12) //validar formato
    private String rut;

    @NotBlank(message = "El teléfono es obligatorio")
    @Size(min = 9, max = 12, message = "El telefono debe tener entre 9 y 12 caracteres")
    @Column(nullable = false, length = 12) //validar formato: validar que no sea letras
    private String telefono;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo no es valido") //validar formato correo valido
    @Column(nullable = false, length = 100)
    private String correo;

    //tablas intermedias-------------------
    @OneToMany(mappedBy = "veterinario")
    private List<Especialidades> especialidades;

    @OneToMany(mappedBy = "veterinario")
    private List<Veterinarios> citas;
}
