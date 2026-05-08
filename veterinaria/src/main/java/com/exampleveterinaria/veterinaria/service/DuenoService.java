package com.exampleveterinaria.veterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampleveterinaria.veterinaria.DTO.DuenoDTO;
import com.exampleveterinaria.veterinaria.model.Dueno;
import com.exampleveterinaria.veterinaria.repository.DuenoRepository;

import jakarta.transaction.Transactional;

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
        if(dueno.getNombre() != null){
            dno.setNombre(dueno.getNombre());
        }
        if(dueno.getRut() != null){
            dno.setRut(dueno.getRut());
        }
        if(dueno.getTelefono() != null){
            dno.setTelefono(dueno.getTelefono());
        }
        if(dueno.getCorreo() != null){
            dno.setCorreo(dueno.getCorreo());
        }
        if(dueno.getDireccion() != null){
            dno.setDireccion(dueno.getDireccion());
        }
        if(dueno.getComuna() != null){
            dno.setComuna(dueno.getComuna());
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

    public void validarRut(String rut){
        if(!validarFormatoRut(rut)){
            throw new RuntimeException("El formato de rut es invalido");
        }
        /*if(!validarDigitoVerificador(rut)) {
            throw new RuntimeException("El digito verificador no es correcto");
        }*/
    }

    public boolean validarFormatoTelefono(String telefono){
        return telefono.trim().matches("\\+569\\d{8}");
    }

    public boolean validarFormatoRut(String rut){
        return rut.trim().matches("\\d{8,9}-[\\dKk]"); //\\d = 0-9
    }

    /*public boolean validarDigitoVerificador(String rut) {

        String[] partes = rut.trim().split("-");
        String numero = partes[0];
        String digitoIngresado = partes[1].toUpperCase();

        int suma = 0;
        int multiplicador = 2;

        for (int i = numero.length() - 1; i >= 0; i--) {
            int digito = Character.getNumericValue(numero.charAt(i));
            suma += digito * multiplicador;
            multiplicador++;
            if (multiplicador == 8) multiplicador = 2;
        }

        int resto = suma % 11;
        int resultado = 11 - resto;

        String digitoCalculado;
        if (resultado == 11) digitoCalculado = "0";
        else if (resultado == 10) digitoCalculado = "K";
        else digitoCalculado = String.valueOf(resultado);

        return digitoCalculado.equals(digitoIngresado);
    }*/
}