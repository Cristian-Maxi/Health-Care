package com.healthtech.demo.filtroConsultas;

import com.healthtech.demo.dto.CrearConsultaDTO;
import com.healthtech.demo.repositories.PacienteRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteActivo implements FiltroDeConsultas{

    @Autowired
    private PacienteRepository pacienteRepository;

    public void filtrarConsulta(CrearConsultaDTO datos) {
        if (datos.idPaciente() == null) {
            return;
        }
        var pacienteActivo = pacienteRepository.findActivoById(datos.idPaciente());

        if (!pacienteActivo) {
            throw new ValidationException("No se puede permitir agendar citas con pacientes inactivos en el sistema");
        }
    }
}
