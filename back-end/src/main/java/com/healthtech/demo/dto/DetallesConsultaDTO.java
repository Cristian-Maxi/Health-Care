package com.healthtech.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public record DetallesConsultaDTO(
        Long id, 
        PsicologoDTO psicologo, 
        PacienteDTO paciente,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime fecha, 
        String linkVideollamada) 
    {
}
