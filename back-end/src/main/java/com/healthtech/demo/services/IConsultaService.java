package com.healthtech.demo.services;

import com.healthtech.demo.dto.CrearConsultaDTO;
import com.healthtech.demo.entities.Consulta;
import java.util.List;

public interface IConsultaService {
    public Consulta Agendar(CrearConsultaDTO datos);
    
    public List<Consulta> getConsultas();
}
