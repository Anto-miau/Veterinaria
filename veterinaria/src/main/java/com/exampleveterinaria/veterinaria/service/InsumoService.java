package com.exampleveterinaria.veterinaria.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.exampleveterinaria.veterinaria.DTO.InsumoDTO;
import com.exampleveterinaria.veterinaria.model.Insumo;
import com.exampleveterinaria.veterinaria.repository.InsumoRepository;

public class InsumoService {
    @Autowired
    private InsumoRepository insumoRepository;

    public List<InsumoDTO> obtenerTodos() {
        return insumoRepository.findAll().stream()
                 .map(this::convertirADTO)
                 .toList();
    }

    public InsumoDTO buscarPorId(Integer id) {
        Insumo insumo = insumoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡Insumo no encontrada!"));
        return convertirADTO(insumo);
    }

    public Insumo guardarInsumo(Insumo insumo) {
        return insumoRepository.save(insumo);
    }


    public Insumo actualizarInsumos(Integer id, Insumo insumo){
        Insumo ins = insumoRepository.findById(id).orElseThrow(() -> new RuntimeException("¡Insumo no existe en los registros!"));
        if(insumo.getAtributo1() != null){
            ins.setAtributo1(insumo.getAtributo1());
        }
        return insumoRepository.save(ins);
    }


    public String eliminar(Integer id) {
        try {
            Insumo insumo = insumoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("¡Imposible eliminar! insumo con ID " + id + " no existe."));
            insumoRepository.delete(insumo);
            return "insumo '" + insumo.getAtributo1() + "' ha sido eliminado exitosamente."; //el atributo1 puede ser nombre por ejemplo
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    private InsumoDTO convertirADTO(Insumo insumo) {
        InsumoDTO dto = new InsumoDTO();
        dto.setId(insumo.getId());
        dto.setNombre(insumo.getNombre());
        dto.setDescripcion(insumo.getDescripcion());
        dto.setStock(insumo.getStock());
        return dto;
    }

    //validaciones-----------------------------------
}
