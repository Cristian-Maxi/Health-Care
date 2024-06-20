package com.healthtech.demo.services;

import com.healthtech.demo.dto.ActualizarPacienteDTO;
import com.healthtech.demo.dto.CrearPacienteDTO;
import com.healthtech.demo.entities.Paciente;
import com.healthtech.demo.entities.Usuario;
import com.healthtech.demo.manejoErrores.ValidacionDeIntegridad;
import com.healthtech.demo.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Paciente> getPacientes() {
        List<Paciente> listaPacientes = pacienteRepository.findAll();
        return listaPacientes;
    }

    //Nuevo Codigo de Cristian
    @Override
    public Paciente savePaciente(CrearPacienteDTO paciente) {
        var existe = pacienteRepository.existsByNombreAndApellido(paciente.nombre(), paciente.apellido());
        if (existe) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El paciente ya existe");
        }
        Usuario usuario = new Usuario(paciente.usuario());
        usuario.setContrasenia(passwordEncoder.encode(paciente.usuario().contrasenia()));
        Paciente pacienteGuardado = new Paciente(paciente);
        pacienteGuardado.setUsuario(usuario);
        return pacienteRepository.save(pacienteGuardado);
    }

    //Nuevo Codigo de Cristian
    @Override
    public void deletePaciente(Long id) {
        if (!pacienteRepository.findById(id).isPresent()) {
            throw new ValidacionDeIntegridad("El paciente con el id " + id + " no existe");
        }
        pacienteRepository.deleteById(id);
    }

    //Nuevo Codigo de Cristian
    public Paciente elegirPaciente(Long id) {
        return pacienteRepository.findByUsuarioId(id)
                .orElseThrow(() -> new ValidacionDeIntegridad("El id del usuario no existe"));
    }

    //Nuevo Codigo de Cristian
    public Paciente modificarPaciente(ActualizarPacienteDTO paciente) {
        if (!pacienteRepository.findById(paciente.id()).isPresent()) {
            throw new ValidacionDeIntegridad("El id del paciente no fue encontrado");
        }
        Paciente pacienteElegido = pacienteRepository.getReferenceById(paciente.id());
        pacienteElegido.ActualizarEntidadPaciente(paciente);
        return pacienteElegido;
    }
}
