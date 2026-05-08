package com.exampleveterinaria.veterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampleveterinaria.veterinaria.DTO.EspecieDTO;
import com.exampleveterinaria.veterinaria.model.Especie;
import com.exampleveterinaria.veterinaria.repository.EspecieRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EspecieService {
    @Autowired
    private EspecieRepository especieRepository;

    public List<EspecieDTO> obtenerTodos() {
        return especieRepository.findAll().stream()
                 .map(this::convertirADTO)
                 .toList();
    }

    public EspecieDTO buscarPorId(Integer id) {
        Especie especie = especieRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡Especie no encontrada!"));
        return convertirADTO(especie);
    }

    public Especie guardarEspecie(Especie especie) {
        return especieRepository.save(especie);
    }


    public Especie actualizarEspecies(Integer id, Especie especie){
        Especie cie = especieRepository.findById(id).orElseThrow(() -> new RuntimeException("¡Especie no existe en los registros!"));
        if(especie.getNombre() != null){
            cie.setNombre(especie.getNombre());
        }
        if(especie.getRazas() != null){
            cie.setRazas(especie.getRazas());
        }
        return especieRepository.save(cie);
    }


    public String eliminar(Integer id) {
        try {
            Especie especie = especieRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("¡Imposible eliminar! especie con ID " + id + " no existe."));
            especieRepository.delete(especie);
            return "especie '" + especie.getNombre() + "' ha sido eliminado exitosamente."; //el atributo1 puede ser nombre por ejemplo
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    private EspecieDTO convertirADTO(Especie especie) {
        EspecieDTO dto = new EspecieDTO();
        dto.setId(especie.getId());
        dto.setNombre(especie.getNombre());
        return dto;
    }

    //validaciones-----------------------------------
}
