package com.exampleveterinaria.veterinaria.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.exampleveterinaria.veterinaria.DTO.EnfermedadDTO;
import com.exampleveterinaria.veterinaria.model.Enfermedad;
import com.exampleveterinaria.veterinaria.repository.EnfermedadRepository;

public class EnfermedadService {
    @Autowired
    private EnfermedadRepository enfermedadRepository;

    public List<EnfermedadDTO> obtenerTodos() {
        return enfermedadRepository.findAll().stream()
                 .map(this::convertirADTO)
                 .toList();
    }

    public EnfermedadDTO buscarPorId(Integer id) {
        Enfermedad enfermedad = enfermedadRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡Enfermedad no encontrada!"));
        return convertirADTO(enfermedad);
    }

    public Enfermedad guardarEnfermedad(Enfermedad enfermedad) {
        return enfermedadRepository.save(enfermedad);
    }


    public Enfermedad actualizarEnfermedads(Integer id, Enfermedad enfermedad){
        Enfermedad enf = enfermedadRepository.findById(id).orElseThrow(() -> new RuntimeException("¡Enfermedad no existe en los registros!"));
        if(enfermedad.getAtributo1() != null){
            enf.setAtributo1(enfermedad.getAtributo1());
        }
        return enfermedadRepository.save(enf);
    }


    public String eliminar(Integer id) {
        try {
            Enfermedad enfermedad = enfermedadRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("¡Imposible eliminar! enfermedad con ID " + id + " no existe."));
            enfermedadRepository.delete(enfermedad);
            return "enfermedad '" + enfermedad.getAtributo1() + "' ha sido eliminado exitosamente."; //el atributo1 puede ser nombre por ejemplo
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    private EnfermedadDTO convertirADTO(Enfermedad enfermedad) {
        EnfermedadDTO dto = new EnfermedadDTO();
        dto.setId(enfermedad.getId());
        dto.setNombre(enfermedad.getNombre());
        dto.setDescripcion(enfermedad.getDescripcion());
        return dto;
    }

    //validaciones-----------------------------------
}
