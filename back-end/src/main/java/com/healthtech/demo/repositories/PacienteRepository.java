package com.healthtech.demo.repositories;

import com.healthtech.demo.entities.Paciente;
import com.healthtech.demo.entities.Psicologo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
    @Query("""
           SELECT p.activo
           FROM Paciente p
           WHERE p.id = :idPaciente
           """)
    Boolean findActivoById(Long idPaciente);
    
    //Nuevo Codigo de Cristian
    boolean existsByNombreAndApellido(String titulo, String mensaje);
    
    Optional<Paciente> findByUsuarioId(Long usuarioId);
}
