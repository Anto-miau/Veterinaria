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

import com.exampleveterinaria.veterinaria.DTO.EspecieDTO;
import com.exampleveterinaria.veterinaria.model.Especie;
import com.exampleveterinaria.veterinaria.service.EspecieService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/especie")
public class EspecieController {

    @Autowired
    private EspecieService especieService;

    @GetMapping
    public ResponseEntity<List<EspecieDTO>> todosLosEspecies() {
        List<EspecieDTO> especies = especieService.obtenerTodos();
        if (especies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(especies, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EspecieDTO> buscarPorId(@PathVariable Integer id) {
        try {
            EspecieDTO cie = especieService.buscarPorId(id);
            return new ResponseEntity<>(cie, HttpStatus.OK);
        } catch (RuntimeException e) {
           // Si el service lanza la excepción del "Especie no existe"
           return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Especie> agregarEspecie(@Valid @RequestBody Especie cie) {
        try {
            Especie guardado = especieService.guardarEspecie(cie);
            return new ResponseEntity<>(guardado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Especie> editarEspecie(@PathVariable Integer id, @Valid @RequestBody Especie cie) {
        try {
            Especie editado = especieService.actualizarEspecies( id, cie);
            return new ResponseEntity<>(editado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Especie> actualizarEspecie(@PathVariable Integer id, @Valid @RequestBody Especie cie){
        try{
            Especie newCit = especieService.actualizarEspecies( id, cie);
            return new ResponseEntity<>(newCit, HttpStatus.OK);
        }catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEspecie(@PathVariable Integer id) {
        String resultado = especieService.eliminar(id);
        
        // Si el mensaje contiene "exitosamente", es un éxito
        if (resultado.contains("exitosamente")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
        }
    }
}
