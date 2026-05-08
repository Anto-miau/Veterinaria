/*package com.exampleveterinaria.veterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.exampleveterinaria.veterinaria.DTO.DuenoDTO;
import com.exampleveterinaria.veterinaria.model.Dueno;
import com.exampleveterinaria.veterinaria.repository.DuenoRepository;

@Service
@Transactional
public class DuenoService {
    @Autowired
    private DuenoRepository duenoRepository;

    public List<DuenoDTO> obtenerTodos() {
        return duenoRepository.findAll().stream()
                 .map(this::convertirADTO)
                 .toList();
    }

    public DuenoDTO buscarPorId(Integer id) {
        Dueno dueno = duenoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡Dueno no encontrada!"));
        return convertirADTO(dueno);
    }

    public Dueno guardarDueno(Dueno dueno) {
        return duenoRepository.save(dueno);
    }


    public Dueno actualizarDuenos(Integer id, Dueno dueno){
        Dueno dno = duenoRepository.findById(id).orElseThrow(() -> new RuntimeException("¡Dueno no existe en los registros!"));
        if(dueno.getAtributo1() != null){
            dno.setAtributo1(dueno.getAtributo1());
        }
        return duenoRepository.save(dno);
    }


    public String eliminar(Integer id) {
        try {
            Dueno dueno = duenoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("¡Imposible eliminar! dueno con ID " + id + " no existe."));
            duenoRepository.delete(dueno);
            return "dueno '" + dueno.getNombre() + "' ha sido eliminado exitosamente."; //el atributo1 puede ser nombre por ejemplo
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    private DuenoDTO convertirADTO(Dueno dueno) {
        DuenoDTO dto = new DuenoDTO();
        dto.setId(dueno.getId());
        dto.setNombre(dueno.getNombre());
        dto.setRut(dueno.getRut());
        dto.setTelefono(dueno.getTelefono());
        dto.setCorreo(dueno.getCorreo());
        dto.setDireccion(dueno.getDireccion());
        if (dueno.getComuna() != null) {
            dto.setNombreComuna(dueno.getComuna().getNombre());
        }
        return dto;
    }

    //validaciones-----------------------------------
}*/
