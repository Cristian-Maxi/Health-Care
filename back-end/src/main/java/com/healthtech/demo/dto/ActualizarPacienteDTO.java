package com.healthtech.demo.dto;

import jakarta.validation.constraints.NotNull;

public record ActualizarPacienteDTO(
        @NotNull
        Long id,
        String nombre,
        String apellido,
        String email,
        String telefono) {

}
