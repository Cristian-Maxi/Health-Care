package com.healthtech.demo.services;

import com.healthtech.demo.dto.ActualizarEmocionDTO;
import com.healthtech.demo.dto.CrearEmocionDTO;
import com.healthtech.demo.entities.Emocion;

import java.util.List;

public interface IEmocionService {

    //Metodo para listar todas las emociones
    List<Emocion> getEmociones();

    //Metodo para dar de alta una emocion
    Emocion saveEmocion(CrearEmocionDTO emocionDTO);

    //Metodo para dar de baja una emocion
    void deleteEmocion(Long id);

    Emocion modificarEmocion(ActualizarEmocionDTO emocionDTO);

    List<Emocion> getEmocionesDelPaciente(Long pacienteId);
}
