package com.healthtech.demo.services;

import com.healthtech.demo.dto.ActualizarEmocionDTO;
import com.healthtech.demo.dto.CrearEmocionDTO;
import com.healthtech.demo.entities.Emocion;
import com.healthtech.demo.manejoErrores.ValidacionDeIntegridad;
import com.healthtech.demo.repositories.EmocionRepository;
import com.healthtech.demo.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmocionService implements IEmocionService {

    @Autowired
    private EmocionRepository emocionRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Emocion> getEmociones() {
        List<Emocion> listaEmociones = emocionRepository.findAll();
        return listaEmociones;
    }

    @Override
    public Emocion saveEmocion(CrearEmocionDTO emocionDTO) {
        var paciente = pacienteRepository.findById(emocionDTO.idPaciente()).get();
        var emocion = new Emocion(emocionDTO, paciente);
        emocionRepository.save(emocion);
        return emocion;
    }

    @Override
    public void deleteEmocion(Long id) {
        emocionRepository.deleteById(id);
    }

    @Override
    public Emocion modificarEmocion(ActualizarEmocionDTO emocionDTO) {
        if (!emocionRepository.findById(emocionDTO.id()).isPresent()) {
            throw new ValidacionDeIntegridad("El id de emocion no fue encontrado");
        }
        Emocion emocionElegida = emocionRepository.getReferenceById(emocionDTO.id());
        emocionElegida.ActualizarEmocion(emocionDTO);
        return emocionElegida;
    }

    public List<Emocion> getEmocionesDelPaciente(Long pacienteId) {
        return emocionRepository.findByPacienteId(pacienteId);
    }
}
