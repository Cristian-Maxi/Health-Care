package com.healthtech.demo.services;

import com.healthtech.demo.dto.*;
import com.healthtech.demo.entities.Consulta;
import com.healthtech.demo.entities.Psicologo;
import com.healthtech.demo.filtroConsultas.FiltroDeConsultas;
import com.healthtech.demo.manejoErrores.ValidacionDeIntegridad;
import com.healthtech.demo.repositories.*;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService implements IConsultaService {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private PsicologoRepository psicologoRepository;
    
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    List<FiltroDeConsultas> filtroConsultas;

    public Consulta Agendar(CrearConsultaDTO datos) {

        //Devuelve un Optional - Trata de recuperar toda la Entidad - Más costoso
        if (!pacienteRepository.findById(datos.idPaciente()).isPresent()) {
            throw new ValidacionDeIntegridad("Este id para el paciente no fue encontrado");
        }
        //Devuelve un True o False - No trata de recuperar toda la Entidad - Menos costoso
        if (datos.idPsicologo() != null && !psicologoRepository.existsById(datos.idPsicologo())) {
            throw new ValidacionDeIntegridad("Este id para el psicologo no fue encontrado");
        }

        //Usamos la interfaz FiltroDeConsultas para aplicar de una vez todas las clases de filtrado que implementen su interfaz
        filtroConsultas.forEach(filtrar -> filtrar.filtrarConsulta(datos));

        //Traemos al Entidad Paciente con el id en cuestion
        var paciente = pacienteRepository.findById(datos.idPaciente()).get();
        //Traemos al Entidad Psicologo con el id en cuestion
        var psicologo = psicologoRepository.findById(datos.idPsicologo()).get();

        //var psicologo = seleccionarPsicologo(datos);
        if (psicologo == null) {
            throw new ValidacionDeIntegridad("no existen psicologos disponibles para este horario y especialidad");
        }

        //CODIGO NUEVO DE NICOLAS PARA GENERAR LINK VIDEOLLAMADA
        String linkVideollamada = generLinkVideollamada();

        //Creamos una nueva Entidad Consulta
        var consulta = new Consulta(psicologo, paciente, datos.fecha(), linkVideollamada);

        //Guardamos la nueva Entidad Consulta en la Base de Datos
        consultaRepository.save(consulta);
        
        return consulta;
    }
    
    @Override
    public List<Consulta> getConsultas() {
        List<Consulta> listaConsultas = consultaRepository.findAll();
        return listaConsultas;
    }

    //NUEVO CODIGO PARA GENERAR LINK VIDEO LLAMADA
    private String generLinkVideollamada() {
        //DE ESTA FORMA, CADA VEZ QUE SE GENERE UNA NUEVA CITA,
        //SE GENERARÁ UNA NUEVA SALA ÚNICA.
        String roomName = "room" + UUID.randomUUID().toString();
        return "https://meet.jit.si/" + roomName;
    }
}
