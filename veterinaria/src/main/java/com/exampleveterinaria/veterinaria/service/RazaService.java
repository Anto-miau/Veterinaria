/*package com.exampleveterinaria.veterinaria.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.exampleveterinaria.veterinaria.DTO.RazaDTO;
import com.exampleveterinaria.veterinaria.model.Raza;
import com.exampleveterinaria.veterinaria.repository.RazaRepository;

public class RazaService {
    @Autowired
    private RazaRepository razaRepository;

    public List<RazaDTO> obtenerTodos() {
        return razaRepository.findAll().stream()
                 .map(this::convertirADTO)
                 .toList();
    }

    public RazaDTO buscarPorId(Integer id) {
        Raza raza = razaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡Raza no encontrada!"));
        return convertirADTO(raza);
    }

    public Raza guardarRaza(Raza raza) {
        return razaRepository.save(raza);
    }


    public Raza actualizarRazas(Integer id, Raza raza){
        Raza raz = razaRepository.findById(id).orElseThrow(() -> new RuntimeException("¡Raza no existe en los registros!"));
        if(raza.getAtributo1() != null){
            raz.setAtributo1(raza.getAtributo1());
        }
        return razaRepository.save(raz);
    }


    public String eliminar(Integer id) {
        try {
            Raza raza = razaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("¡Imposible eliminar! raza con ID " + id + " no existe."));
            razaRepository.delete(raza);
            return "raza '" + raza.getAtributo1() + "' ha sido eliminado exitosamente."; //el atributo1 puede ser nombre por ejemplo
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    private RazaDTO convertirADTO(Raza raza) {
        RazaDTO dto = new RazaDTO();
        dto.setId(raza.getId());
        dto.setNombre(raza.getNombre());
        if (raza.getEspecie() != null) {
            dto.setNombreEspecie(raza.getEspecie().getNombre());
        }
        return dto;
    }

    

    //validaciones-----------------------------------
}*/
