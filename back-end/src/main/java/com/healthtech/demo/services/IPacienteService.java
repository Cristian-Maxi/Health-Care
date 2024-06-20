package com.healthtech.demo.services;

import com.healthtech.demo.dto.ActualizarPacienteDTO;
import com.healthtech.demo.dto.CrearPacienteDTO;
import com.healthtech.demo.entities.Paciente;

import java.util.List;

public interface IPacienteService {

    //metodo para traer todos los pacientes
    public List<Paciente> getPacientes();
    
    //Nuevo Codigo de Cristian
    //metodo para dar de alta un paciente
    public Paciente savePaciente(CrearPacienteDTO paciente);

    //metodo para dar de baja un paciente
    public void deletePaciente(Long id);
    
    //Nuevo Codigo de Cristian
    //metodo para elegiar un paciente en particular
    public Paciente elegirPaciente(Long id);
    
    public Paciente modificarPaciente(ActualizarPacienteDTO paciente);

}
