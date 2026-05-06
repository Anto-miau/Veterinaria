package com.exampleveterinaria.veterinaria.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.exampleveterinaria.veterinaria.DTO.VeterinarioDTO;
import com.exampleveterinaria.veterinaria.model.Veterinario;
import com.exampleveterinaria.veterinaria.repository.VeterinarioRepository;

public class VeterinarioService {
    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public List<VeterinarioDTO> obtenerTodos() {
        return veterinarioRepository.findAll().stream()
                 .map(this::convertirADTO)
                 .toList();
    }

    public VeterinarioDTO buscarPorId(Integer id) {
        Veterinario veterinario = veterinarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡Veterinario no encontrada!"));
        return convertirADTO(veterinario);
    }

    public Veterinario guardarVeterinario(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }


    public Veterinario actualizarVeterinarios(Integer id, Veterinario veterinario){
        Veterinario vet = veterinarioRepository.findById(id).orElseThrow(() -> new RuntimeException("¡Veterinario no existe en los registros!"));
        if(veterinario.getAtributo1() != null){
            vet.setAtributo1(veterinario.getAtributo1());
        }
        return veterinarioRepository.save(vet);
    }


    public String eliminar(Integer id) {
        try {
            Veterinario veterinario = veterinarioRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("¡Imposible eliminar! veterinario con ID " + id + " no existe."));
            veterinarioRepository.delete(veterinario);
            return "veterinario '" + veterinario.getAtributo1() + "' ha sido eliminado exitosamente."; //el atributo1 puede ser nombre por ejemplo
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    private VeterinarioDTO convertirADTO(Veterinario veterinario) {
        VeterinarioDTO dto = new VeterinarioDTO();
        dto.setId(veterinario.getId());
        dto.setNombre(veterinario.getNombre());
        dto.setRut(veterinario.getRut());
        dto.setTelefono(veterinario.getTelefono());
        dto.setCorreo(veterinario.getCorreo());
        return dto;
    }

    //validaciones-----------------------------------
}
