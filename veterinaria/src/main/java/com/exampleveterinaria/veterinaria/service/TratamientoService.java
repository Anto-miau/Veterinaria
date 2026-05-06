package com.exampleveterinaria.veterinaria.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.exampleveterinaria.veterinaria.DTO.TratamientoDTO;
import com.exampleveterinaria.veterinaria.model.Tratamiento;
import com.exampleveterinaria.veterinaria.repository.TratamientoRepository;

public class TratamientoService {
    @Autowired
    private TratamientoRepository tratamientoRepository;

    public List<TratamientoDTO> obtenerTodos() {
        return tratamientoRepository.findAll().stream()
                 .map(this::convertirADTO)
                 .toList();
    }

    public TratamientoDTO buscarPorId(Integer id) {
        Tratamiento tratamiento = tratamientoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡Tratamiento no encontrada!"));
        return convertirADTO(tratamiento);
    }

    public Tratamiento guardarTratamiento(Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }


    public Tratamiento actualizarTratamientos(Integer id, Tratamiento tratamiento){
        Tratamiento trat = tratamientoRepository.findById(id).orElseThrow(() -> new RuntimeException("¡Tratamiento no existe en los registros!"));
        if(tratamiento.getAtributo1() != null){
            trat.setAtributo1(tratamiento.getAtributo1());
        }
        return tratamientoRepository.save(trat);
    }


    public String eliminar(Integer id) {
        try {
            Tratamiento tratamiento = tratamientoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("¡Imposible eliminar! tratamiento con ID " + id + " no existe."));
            tratamientoRepository.delete(tratamiento);
            return "tratamiento '" + tratamiento.getAtributo1() + "' ha sido eliminado exitosamente."; //el atributo1 puede ser nombre por ejemplo
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    private TratamientoDTO convertirADTO(Tratamiento tratamiento) {
        TratamientoDTO dto = new TratamientoDTO();
        dto.setId(tratamiento.getId());
        dto.setDiagnostico(tratamiento.getDiagnostico());
        dto.setDescripcion(tratamiento.getDescripcion());
        dto.setFechaInicio(tratamiento.getFechaInicio());
        dto.setFechaTermino(tratamiento.getFechaTermino());
        return dto;
    }

    //validaciones-----------------------------------
}
