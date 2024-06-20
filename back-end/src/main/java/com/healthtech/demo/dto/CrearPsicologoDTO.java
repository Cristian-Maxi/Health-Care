package com.healthtech.demo.dto;

import com.healthtech.demo.enums.Especialidad;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record CrearPsicologoDTO(
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
        @NotNull
        String descripcion,
        @NotNull
        Especialidad especialidad,
        @NotNull @Valid
        UsuarioDTO usuario){

}
