package com.healthtech.demo.controllers;

import com.healthtech.demo.dto.*;
import com.healthtech.demo.entities.Paciente;
import com.healthtech.demo.services.PacienteService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
@SecurityRequirement(name = "bearer-key") //Necesario para Swagger UI con Bearer Tokens
public class ControladorPaciente {

    //Se usa Autowired solo durante la prueba
    @Autowired
    private PacienteService pacienteService;

    @Transactional
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity eliminarPaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
        return ResponseEntity.ok("El usuario fue eliminado exitosamente");
    }

    @GetMapping("/listarPacientes")
    public ResponseEntity<List<ListarPacienteDTO>> listarPacientes() {
        List<Paciente> pacientes = pacienteService.getPacientes();
        List<ListarPacienteDTO> pacientesDTO = pacientes.stream()
                .map(paciente -> new ListarPacienteDTO(
                paciente.getId(),
                paciente.getNombre(),
                paciente.getApellido(),
                paciente.getEmail(),
                paciente.getTelefono(),
                paciente.getDocumento(),
                paciente.getRol())).collect(Collectors.toList());
        return ResponseEntity.ok(pacientesDTO);
    }

    @GetMapping("/seleccionar/{id}")
    public ResponseEntity<ListarPacienteDTO> seleccionarPaciente(@PathVariable Long id) {
        Paciente pacienteElegido = pacienteService.elegirPaciente(id);
        ListarPacienteDTO pacienteDTO = new ListarPacienteDTO(
                pacienteElegido.getId(),
                pacienteElegido.getNombre(),
                pacienteElegido.getApellido(),
                pacienteElegido.getEmail(),
                pacienteElegido.getTelefono(),
                pacienteElegido.getDocumento(),
                pacienteElegido.getRol());
        return ResponseEntity.ok(pacienteDTO);
    }

    @Transactional
    @PutMapping("/modificar")
    public ResponseEntity<ActualizarPacienteDTO> actualizarPaciente(@RequestBody @Valid ActualizarPacienteDTO paciente) {
        Paciente pacienteModificado = pacienteService.modificarPaciente(paciente);
        ActualizarPacienteDTO pacienteDTO = new ActualizarPacienteDTO(
                pacienteModificado.getId(),
                pacienteModificado.getNombre(),
                pacienteModificado.getApellido(),
                pacienteModificado.getEmail(),
                pacienteModificado.getTelefono());
        return ResponseEntity.ok(pacienteDTO);
    }
}
