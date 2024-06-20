package com.healthtech.demo.repositories;

import com.healthtech.demo.entities.Psicologo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PsicologoRepository extends JpaRepository<Psicologo, Long> {
    @Query("""
           SELECT p.activo
           FROM Psicologo p
           WHERE p.id = :idPsicologo
           """)
    Boolean findActivoById(Long idPsicologo);

    Boolean existsByDocumento(String titulo);
    
    Optional<Psicologo> findByUsuarioId(Long usuarioId);
}
