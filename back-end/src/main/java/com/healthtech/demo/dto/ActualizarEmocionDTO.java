package com.healthtech.demo.dto;

import com.healthtech.demo.enums.TipoEmocion;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ActualizarEmocionDTO(
        @NotNull
        Long id,
        TipoEmocion tipoEmocion,
        String descripcion) {
}
