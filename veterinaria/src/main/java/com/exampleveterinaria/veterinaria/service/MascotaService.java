package com.exampleveterinaria.veterinaria.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.exampleveterinaria.veterinaria.DTO.MascotaDTO;
import com.exampleveterinaria.veterinaria.model.Mascota;
import com.exampleveterinaria.veterinaria.repository.MascotaRepository;

public class MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;

    public List<MascotaDTO> obtenerTodos() {
        return mascotaRepository.findAll().stream()
                 .map(this::convertirADTO)
                 .toList();
    }

    public MascotaDTO buscarPorId(Integer id) {
        Mascota mascota = mascotaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡Mascota no encontrada!"));
        return convertirADTO(mascota);
    }

    public Mascota guardarMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }


    public Mascota actualizarMascotas(Integer id, Mascota mascota){
        Mascota mas = mascotaRepository.findById(id).orElseThrow(() -> new RuntimeException("¡Mascota no existe en los registros!"));
        if(mascota.getAtributo1() != null){
            mas.setAtributo1(mascota.getAtributo1());
        }
        return mascotaRepository.save(mas);
    }


    public String eliminar(Integer id) {
        try {
            Mascota mascota = mascotaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("¡Imposible eliminar! mascota con ID " + id + " no existe."));
            mascotaRepository.delete(mascota);
            return "mascota '" + mascota.getAtributo1() + "' ha sido eliminado exitosamente."; //el atributo1 puede ser nombre por ejemplo
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    private MascotaDTO convertirADTO(Mascota mascota) {
        MascotaDTO dto = new MascotaDTO();
        dto.setId(mascota.getId());
        dto.setNombre(mascota.getNombre());
        dto.setColor(mascota.getColor());
        dto.setEdad(mascota.getEdad());
        dto.setSexo(mascota.getSexo());

        if (mascota.getDueno() != null) {
            dto.setNombreDueno(mascota.getDueno().getNombre());
        }
        if (mascota.getRaza() != null) {
            dto.setNombreRaza(mascota.getRaza().getNombre());
        }
        return dto;
    }

    //validaciones-----------------------------------
}
