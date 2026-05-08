/*package com.exampleveterinaria.veterinaria.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.exampleveterinaria.veterinaria.DTO.ContactoDTO;
import com.exampleveterinaria.veterinaria.model.Contacto;
import com.exampleveterinaria.veterinaria.repository.ContactoRepository;

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
        if(contacto.getAtributo1() != null){
            cont.setAtributo1(contacto.getAtributo1());
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
