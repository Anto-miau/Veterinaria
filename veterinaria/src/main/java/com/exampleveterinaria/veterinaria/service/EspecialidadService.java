package com.exampleveterinaria.veterinaria.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.exampleveterinaria.veterinaria.DTO.EspecialidadDTO;
import com.exampleveterinaria.veterinaria.model.Especialidad;
import com.exampleveterinaria.veterinaria.repository.EspecialidadRepository;

public class EspecialidadService {
    @Autowired
    private EspecialidadRepository especialidadRepository;

    public List<EspecialidadDTO> obtenerTodos() {
        return especialidadRepository.findAll().stream()
                 .map(this::convertirADTO)
                 .toList();
    }

    public EspecialidadDTO buscarPorId(Integer id) {
        Especialidad especialidad = especialidadRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡Especialidad no encontrada!"));
        return convertirADTO(especialidad);
    }

    public Especialidad guardarEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }


    public Especialidad actualizarEspecialidads(Integer id, Especialidad especialidad){
        Especialidad cialidad = especialidadRepository.findById(id).orElseThrow(() -> new RuntimeException("¡Especialidad no existe en los registros!"));
        if(especialidad.getAtributo1() != null){
            cialidad.setAtributo1(especialidad.getAtributo1());
        }
        return especialidadRepository.save(cialidad);
    }


    public String eliminar(Integer id) {
        try {
            Especialidad especialidad = especialidadRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("¡Imposible eliminar! especialidad con ID " + id + " no existe."));
            especialidadRepository.delete(especialidad);
            return "especialidad '" + especialidad.getAtributo1() + "' ha sido eliminado exitosamente."; //el atributo1 puede ser nombre por ejemplo
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    private EspecialidadDTO convertirADTO(Especialidad especialidad) {
        EspecialidadDTO dto = new EspecialidadDTO();
        dto.setId(especialidad.getId());
        dto.setNombre(especialidad.getNombre());
        return dto;
    }

    //validaciones-----------------------------------
}
