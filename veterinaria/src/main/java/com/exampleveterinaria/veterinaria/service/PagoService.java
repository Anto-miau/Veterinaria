/*package com.exampleveterinaria.veterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.exampleveterinaria.veterinaria.DTO.PagoDTO;
import com.exampleveterinaria.veterinaria.model.Pago;
import com.exampleveterinaria.veterinaria.repository.PagoRepository;

public class PagoService {
    @Autowired
    private PagoRepository pagoRepository;

    public List<PagoDTO> obtenerTodos() {
        return pagoRepository.findAll().stream()
                 .map(this::convertirADTO)
                 .toList();
    }

    public PagoDTO buscarPorId(Integer id) {
        Pago pago = pagoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡Pago no encontrada!"));
        return convertirADTO(pago);
    }

    public Pago guardarPago(Pago pago) {
        return pagoRepository.save(pago);
    }


    public Pago actualizarPagos(Integer id, Pago pago){
        Pago pag = pagoRepository.findById(id).orElseThrow(() -> new RuntimeException("¡Pago no existe en los registros!"));
        if(pago.getAtributo1() != null){
            pag.setAtributo1(pago.getAtributo1());
        }
        return pagoRepository.save(pag);
    }


    public String eliminar(Integer id) {
        try {
            Pago pago = pagoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("¡Imposible eliminar! pago con ID " + id + " no existe."));
            pagoRepository.delete(pago);
            return "pago '" + pago.getAtributo1() + "' ha sido eliminado exitosamente."; //el atributo1 puede ser nombre por ejemplo
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    private PagoDTO convertirADTO(Pago Pago) {
        PagoDTO dto = new PagoDTO();
        dto.setId(Pago.getId());
        dto.setNombre(Pago.getNombre());
        return dto;
    }

    //validaciones-----------------------------------
}*/
