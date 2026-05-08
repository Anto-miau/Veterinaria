package com.exampleveterinaria.veterinaria.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El color es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 100 caracteres")
    @Column(nullable = false, length = 50)
    private String color;

    @Min(value = 0)
    @Column(nullable = false)  //validar edad o que fuese autoincrementable?
    private Integer edad;

    @Column(nullable = true)
    private Date fechaNacimiento;

    @NotBlank(message = "El sexo es obligatorio") //validar formato
    @Column(nullable = false, length = 10)
    private String sexo;

    //relaciones------------------------------------------
    @ManyToOne
    @JoinColumn(name = "dueno_id", nullable = false)
    private Dueno dueno;

    @ManyToOne
    @JoinColumn(name = "raza_id", nullable = false)
    private Raza raza;

    @OneToMany(mappedBy = "mascota")
    private List<Cita> citas;

    //tablas intermedias----------------------------------
    @OneToMany(mappedBy = "mascota")
    private List<Contactos> contactos;

    @OneToMany(mappedBy = "mascota")
    private List<Enfermedades> enfermedades;

}
