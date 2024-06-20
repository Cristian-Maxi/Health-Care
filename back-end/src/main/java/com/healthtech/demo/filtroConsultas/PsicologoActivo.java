package com.healthtech.demo.filtroConsultas;

import com.healthtech.demo.dto.CrearConsultaDTO;
import com.healthtech.demo.repositories.PsicologoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PsicologoActivo implements FiltroDeConsultas{

    @Autowired
    private PsicologoRepository psicologoRepository;

    public void filtrarConsulta(CrearConsultaDTO datos) {
        if (datos.idPsicologo()== null) {
            return;
        }
        var psicologoActivo = psicologoRepository.findActivoById(datos.idPsicologo());

        if (!psicologoActivo) {
            throw new ValidationException("No se puede permitir agendar citas con pacientes inactivos en el sistema");
        }
    }
}
