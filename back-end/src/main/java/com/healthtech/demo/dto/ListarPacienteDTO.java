package com.healthtech.demo.dto;

public record ListarPacienteDTO(
        Long id,
        String nombre,
        String apellido,
        String email,
        String telefono,
        String documento,
        String rol) {
}
