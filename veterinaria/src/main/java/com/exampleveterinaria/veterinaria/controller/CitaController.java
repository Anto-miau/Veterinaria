package com.exampleveterinaria.veterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampleveterinaria.veterinaria.DTO.CitaDTO;
import com.exampleveterinaria.veterinaria.model.Cita;
import com.exampleveterinaria.veterinaria.service.CitaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping
    public ResponseEntity<List<CitaDTO>> todosLosCitas() {
        List<CitaDTO> citas = citaService.obtenerTodos();
        if (citas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CitaDTO> buscarPorId(@PathVariable Integer id) {
        try {
            CitaDTO cit = citaService.buscarPorId(id);
            return new ResponseEntity<>(cit, HttpStatus.OK);
        } catch (RuntimeException e) {
           // Si el service lanza la excepción del "Cita no existe"
           return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Cita> agregarCita(@Valid @RequestBody Cita cit) {
        try {
            Cita guardado = citaService.guardarCita(cit);
            return new ResponseEntity<>(guardado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Cita> editarCita(@PathVariable Integer id, @Valid @RequestBody Cita cit) {
        try {
            Cita editado = citaService.guardarCita(cit);
            return new ResponseEntity<>(editado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Cita> actualizarCita(@PathVariable Integer id, @Valid @RequestBody Cita cit){
        try{
            Cita newCit = citaService.actualizarCitas( id, cit);
            return new ResponseEntity<>(newCit, HttpStatus.OK);
        }catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCita(@PathVariable Integer id) {
        String resultado = citaService.eliminar(id);
        
        // Si el mensaje contiene "exitosamente", es un éxito
        if (resultado.contains("exitosamente")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
        }
    }

}
