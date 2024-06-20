package com.healthtech.demo.controllers;

import com.healthtech.demo.dto.*;
import com.healthtech.demo.manejoErrores.ValidacionDeIntegridad;
import com.healthtech.demo.services.ConsultaService;
import com.healthtech.demo.services.EmailService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulta")
@SecurityRequirement(name = "bearer-key") //Necesario para Swagger UI con Bearer Tokens
public class ControladorConsulta {

    @Autowired
    private ConsultaService consultaService;
    @Autowired
    private EmailService emailService;

    @PostMapping("/crear")
    public ResponseEntity<DetallesConsultaDTO> agendarConsulta(@RequestBody @Valid CrearConsultaDTO datos) throws ValidacionDeIntegridad {
        var consulta = consultaService.Agendar(datos);
        //NUEVO CODIGO PARA EL MAILSENDER
        String emailTexto = "Su cita fue agendada con exito! Unase a la misma el siguiente link: " + consulta.getLinkVideollamada();
        emailService.enviarConsultaPorMail(consulta.getPaciente().getEmail(), "Nueva cita programada", emailTexto);
        emailService.enviarConsultaPorMail(consulta.getPsicologo().getEmail(), "Nueva consulta", emailTexto);

        //Esto devulve un error, pero si se guarda en la DB
        return ResponseEntity.ok(new DetallesConsultaDTO(
                consulta.getId(),
                new PsicologoDTO(consulta.getPsicologo().getNombre(), consulta.getPsicologo().getApellido(), consulta.getPsicologo().getDocumento()),
                new PacienteDTO(consulta.getPaciente().getNombre(), consulta.getPaciente().getApellido(), consulta.getPaciente().getDocumento()),
                consulta.getFecha(), consulta.getLinkVideollamada()));
    }

    @GetMapping("/listarConsultas")
    public ResponseEntity<List<DetallesConsultaDTO>> listarConsultas() {
        var consultas = consultaService.getConsultas();
        List<DetallesConsultaDTO> listarConsultas = consultas.stream()
                .map(consulta -> new DetallesConsultaDTO(
                consulta.getId(),
                new PsicologoDTO(consulta.getPsicologo().getNombre(), consulta.getPsicologo().getApellido(), consulta.getPsicologo().getDocumento()),
                new PacienteDTO(consulta.getPaciente().getNombre(), consulta.getPaciente().getApellido(), consulta.getPaciente().getDocumento()),
                consulta.getFecha(), consulta.getLinkVideollamada())).collect(Collectors.toList());
        return ResponseEntity.ok(listarConsultas);
    }
}
