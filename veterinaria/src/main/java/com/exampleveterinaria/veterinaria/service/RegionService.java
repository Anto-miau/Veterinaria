package com.exampleveterinaria.veterinaria.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.exampleveterinaria.veterinaria.DTO.RegionDTO;
import com.exampleveterinaria.veterinaria.model.Region;
import com.exampleveterinaria.veterinaria.repository.RegionRepository;

public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public List<RegionDTO> obtenerTodos() {
        return regionRepository.findAll().stream()
                 .map(this::convertirADTO)
                 .toList();
    }

    public RegionDTO buscarPorId(Integer id) {
        Region region = regionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡Region no encontrada!"));
        return convertirADTO(region);
    }

    public Region guardarRegion(Region region) {
        return regionRepository.save(region);
    }


    public Region actualizarRegions(Integer id, Region region){
        Region reg = regionRepository.findById(id).orElseThrow(() -> new RuntimeException("¡Region no existe en los registros!"));
        if(region.getAtributo1() != null){
            reg.setAtributo1(region.getAtributo1());
        }
        return regionRepository.save(reg);
    }


    public String eliminar(Integer id) {
        try {
            Region region = regionRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("¡Imposible eliminar! region con ID " + id + " no existe."));
            regionRepository.delete(region);
            return "region '" + region.getAtributo1() + "' ha sido eliminado exitosamente."; //el atributo1 puede ser nombre por ejemplo
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    private RegionDTO convertirADTO(Region region) {
        RegionDTO dto = new RegionDTO();
        dto.setId(region.getId());
        dto.setNombre(region.getNombre());
        return dto;
    }

    //validaciones-----------------------------------
}
