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

import com.exampleveterinaria.veterinaria.DTO.ComunaDTO;
import com.exampleveterinaria.veterinaria.model.Comuna;
import com.exampleveterinaria.veterinaria.service.ComunaService;

@RestController
@RequestMapping("api/v1/comunas")
public class ComunaController {

    @Autowired
    private ComunaService comunaService;

    @GetMapping
    public ResponseEntity<List<ComunaDTO>> todosLosComunas() {
        List<ComunaDTO> comunas = comunaService.obtenerTodos();
        if (comunas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(comunas, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ComunaDTO> buscarPorId(@PathVariable Integer id) {
        try {
            ComunaDTO com = comunaService.buscarPorId(id);
            return new ResponseEntity<>(com, HttpStatus.OK);
        } catch (RuntimeException e) {
           // Si el service lanza la excepción del "Comuna no existe"
           return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Comuna> agregarComuna(@RequestBody Comuna com) {
        try {
            Comuna guardado = comunaService.guardarComuna(com);
            return new ResponseEntity<>(guardado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Comuna> editarComuna(@PathVariable Integer id, @RequestBody Comuna com) {
        try {
            Comuna editado = comunaService.guardarComuna(com);
            return new ResponseEntity<>(editado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Comuna> actualizarComuna(@PathVariable Integer id, @RequestBody Comuna com){
        try{
            Comuna newCom = comunaService.actualizarComunas( id, com);
            return new ResponseEntity<>(newCom, HttpStatus.OK);
        }catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarComuna(@PathVariable Integer id) {
        String resultado = comunaService.eliminar(id);
        
        // Si el mensaje contiene "exitosamente", es un éxito
        if (resultado.contains("exitosamente")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
        }
    }

}

