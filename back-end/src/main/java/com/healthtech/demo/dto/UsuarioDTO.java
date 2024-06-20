package com.healthtech.demo.dto;

import jakarta.validation.constraints.NotNull;

public record UsuarioDTO(
        @NotNull
        String usuario,
        @NotNull
        String contrasenia) {
}
