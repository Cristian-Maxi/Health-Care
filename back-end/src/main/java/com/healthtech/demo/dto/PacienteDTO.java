package com.healthtech.demo.dto;

import jakarta.validation.constraints.NotNull;

public record PacienteDTO(
        @NotNull
        String nombre,
        @NotNull
        String apellido,
        @NotNull
        String documento) {
}
