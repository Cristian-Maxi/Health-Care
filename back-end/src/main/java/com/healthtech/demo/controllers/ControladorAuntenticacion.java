package com.healthtech.demo.controllers;

import com.healthtech.demo.dto.*;
import com.healthtech.demo.entities.Usuario;
import com.healthtech.demo.security.TokenService;
import com.healthtech.demo.services.PacienteService;
import com.healthtech.demo.services.PsicologoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class ControladorAuntenticacion {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private PsicologoService psicologoService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity autenticarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(usuarioDTO.usuario(),
                usuarioDTO.contrasenia());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var usuario = (Usuario) usuarioAutenticado.getPrincipal();

        // Obtener el rol del usuario
        String rol = "UNKNOWN";
        try {
            var paciente = pacienteService.elegirPaciente(usuario.getId());
            if (paciente != null) {
                rol = paciente.getRol();
            }
        } catch (Exception e) {
            // No se encontró el paciente, intentar con psicólogo
            var psicologo = psicologoService.elegirPsicologo(usuario.getId());
            if (psicologo != null) {
                rol = psicologo.getRol();
            }
        }

        // Generar el token con el rol incluido
        String jwtToken = tokenService.generarToken(usuario, rol);
        return ResponseEntity.ok(new JWTTokenDTO(jwtToken));
    }

    @Transactional
    @PostMapping("/sign-up")
    public ResponseEntity<CrearPacienteDTO> crearPaciente(@RequestBody @Valid CrearPacienteDTO paciente) {
        pacienteService.savePaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(paciente);
    }
}
