package com.healthtech.demo.dto;

import com.healthtech.demo.enums.TipoEmocion;
import jakarta.validation.constraints.*;

public record CrearEmocionDTO(
        @NotNull
        Long idPaciente,
        @NotBlank
        String descripcion,
        @NotNull
        TipoEmocion tipoEmocion) {

}
