/*package com.exampleveterinaria.veterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampleveterinaria.veterinaria.DTO.ContactoDTO;
import com.exampleveterinaria.veterinaria.model.Contacto;
import com.exampleveterinaria.veterinaria.repository.ContactoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ContactoService {
    @Autowired
    private ContactoRepository contactoRepository;

    public List<ContactoDTO> obtenerTodos() {
        return contactoRepository.findAll().stream()
                 .map(this::convertirADTO)
                 .toList();
    }

    public ContactoDTO buscarPorId(Integer id) {
        Contacto contacto = contactoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡Contacto no encontrada!"));
        return convertirADTO(contacto);
    }

    public Contacto guardarContacto(Contacto contacto) {
        return contactoRepository.save(contacto);
    }


    public Contacto actualizarContactos(Integer id, Contacto contacto){
        Contacto cont = contactoRepository.findById(id).orElseThrow(() -> new RuntimeException("¡Contacto no existe en los registros!"));
        if(contacto.getNombre() != null){
            cont.setNombre(contacto.getNombre());
        }
        if(contacto.getTelefono() != null){
            cont.setTelefono(contacto.getTelefono());
        }
        return contactoRepository.save(cont);
    }


    public String eliminar(Integer id) {
        try {
            Contacto contacto = contactoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("¡Imposible eliminar! contacto con ID " + id + " no existe."));
            contactoRepository.delete(contacto);
            return "contacto '" + contacto.getAtributo1() + "' ha sido eliminado exitosamente."; //el atributo1 puede ser nombre por ejemplo
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    private ContactoDTO convertirADTO(Contacto contacto) {
        ContactoDTO dto = new ContactoDTO();
        dto.setId(contacto.getId());
        dto.setNombre(contacto.getNombre());
        dto.setTelefono(contacto.getTelefono());
        dto.setCorreo(contacto.getCorreo());
        return dto;
    }

    //validaciones-----------------------------------
}*/
