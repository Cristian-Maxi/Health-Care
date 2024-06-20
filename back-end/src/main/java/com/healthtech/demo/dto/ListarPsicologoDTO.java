package com.healthtech.demo.dto;

import com.healthtech.demo.enums.Especialidad;

public record ListarPsicologoDTO(
        Long id,
        String nombre,
        String apellido,
        String email,
        String telefono,
        String documento,
        String descripcion,
        String rol,
        int valoracion,
        Especialidad especialidad) {
}


