package com.healthtech.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.healthtech.demo.enums.TipoEmocion;

import java.time.LocalDateTime;

public record ListarEmocionDTO(
        Long id,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime fechaCreacion,
        String descripcion,
        TipoEmocion tipoEmocion,
        EmocionPacienteDTO paciente
) {
}
