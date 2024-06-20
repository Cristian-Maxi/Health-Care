package com.healthtech.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record CrearPacienteDTO(
        @NotNull
        String nombre,
        @NotNull
        String apellido,
        @Email
        String email,
        @NotBlank
        @Size(min = 0, max = 15)
        String telefono,
        @NotNull
        String documento,
        @NotNull @Valid
        UsuarioDTO usuario) {

}
