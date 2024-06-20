package com.healthtech.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.healthtech.demo.enums.Especialidad;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record CrearConsultaDTO(
        @NotNull
        Especialidad especilidad,
//        @NotNull @Valid
//        PsicologoDTO psicologo,
//        @NotNull @Valid
//        PacienteDTO paciente,
        @NotNull
        Long idPsicologo,
        @NotNull
        Long idPaciente,
        @NotNull
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime fecha){
}
