package com.exampleveterinaria.veterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampleveterinaria.veterinaria.DTO.CitaDTO;
import com.exampleveterinaria.veterinaria.model.Cita;
import com.exampleveterinaria.veterinaria.repository.CitaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CitaService {
    
    @Autowired
    private CitaRepository citaRepository;

    public List<CitaDTO> obtenerTodos() {
        return citaRepository.findAll().stream().map(this::convertirADTO).toList();
    }

    public CitaDTO buscarPorId(Integer id) {
        Cita cita = citaRepository.findById(id).orElseThrow(() -> new RuntimeException("¡Cita no encontrada!"));
        return convertirADTO(cita);
    }

    public Cita guardarCita(Cita cita) {
        return citaRepository.save(cita);
    }

    public Cita actualizarCitas(Integer id, Cita cita){
        Cita cit = citaRepository.findById(id).orElseThrow(() -> new RuntimeException("¡Cita no existe en los registros!"));
        if(cita.getFechaHora() != null){
            cit.setFechaHora(cita.getFechaHora());
        }
        if(cita.getMotivo() != null){
            cit.setMotivo(cita.getMotivo());
        }
        if(cita.getEstado() != null){
            cit.setEstado(cita.getEstado());
        }
        return citaRepository.save(cit);
    }

    public String eliminar(Integer id) {
        try {
            Cita cita = citaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("¡Imposible eliminar! cita con ID " + id + " no existe."));
            citaRepository.delete(cita);
            return "La cita '" + cita.getId() + "' ha sido eliminada exitosamente.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    private CitaDTO convertirADTO(Cita cita) {
        CitaDTO dto = new CitaDTO();
        dto.setId(cita.getId());
        dto.setFechaHora(cita.getFechaHora());
        dto.setMotivo(cita.getMotivo());
        dto.setEstado(cita.getEstado());
        
        if (cita.getMascota() != null) {
        dto.setNombreMascota(cita.getMascota().getNombre());
        }
        return dto;
    }

    //validaciones----------------------------------
}
