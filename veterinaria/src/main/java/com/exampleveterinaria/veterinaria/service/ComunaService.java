package com.exampleveterinaria.veterinaria.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.exampleveterinaria.veterinaria.DTO.ComunaDTO;
import com.exampleveterinaria.veterinaria.model.Comuna;
import com.exampleveterinaria.veterinaria.repository.ComunaRepository;

public class ComunaService {
    @Autowired
    private ComunaRepository comunaRepository;

    public List<ComunaDTO> obtenerTodos() {
        return comunaRepository.findAll().stream()
                 .map(this::convertirADTO)
                 .toList();
    }

    public ComunaDTO buscarPorId(Integer id) {
        Comuna comuna = comunaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡Comuna no encontrada!"));
        return convertirADTO(comuna);
    }

    public Comuna guardarComuna(Comuna comuna) {
        return comunaRepository.save(comuna);
    }


    public Comuna actualizarComunas(Integer id, Comuna comuna){
        Comuna comu = comunaRepository.findById(id).orElseThrow(() -> new RuntimeException("¡Comuna no existe en los registros!"));
        if(comuna.getAtributo1() != null){
            comu.setAtributo1(comuna.getAtributo1());
        }
        return comunaRepository.save(comu);
    }


    public String eliminar(Integer id) {
        try {
            Comuna comuna = comunaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("¡Imposible eliminar! comuna con ID " + id + " no existe."));
            comunaRepository.delete(comuna);
            return "comuna '" + comuna.getAtributo1() + "' ha sido eliminado exitosamente."; //el atributo1 puede ser nombre por ejemplo
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    private ComunaDTO convertirADTO(Comuna comuna) {
        ComunaDTO dto = new ComunaDTO();
        dto.setId(comuna.getId());
        dto.setNombre(comuna.getNombre());
            if (comuna.getRegion() != null) {
                dto.setNombreRegion(comuna.getRegion().getNombre());
        }
        return dto;
    }

    //validaciones-----------------------------------
}
