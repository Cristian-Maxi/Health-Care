package com.healthtech.demo.entities;

import com.healthtech.demo.dto.ActualizarPsicologoDTO;
import com.healthtech.demo.dto.CrearPsicologoDTO;
import com.healthtech.demo.enums.Especialidad;
import jakarta.persistence.*;

import java.util.List;

import lombok.*;

import java.util.concurrent.ThreadLocalRandom;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Psicologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String email;

    private String telefono;

    private String documento;

    private String descripcion;
    
    private String rol;

    private Boolean activo;

    private int valoracion;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    //Se agtego usuario al Medico
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "psicologo_paciente", joinColumns = @JoinColumn(name = "id_psicologo"), inverseJoinColumns = @JoinColumn(name = "id_paciente"))
    private List<Paciente> pacientes;

    @OneToOne(mappedBy = "psicologo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Consulta consulta; // Relación uno a uno con Consulta

    public Psicologo(CrearPsicologoDTO psicologo) {
        this.nombre = psicologo.nombre();
        this.apellido = psicologo.apellido();
        this.email = psicologo.email();
        this.telefono = psicologo.telefono();
        this.documento = psicologo.documento();
        this.descripcion = psicologo.descripcion();
        this.rol = "psicologo";
        this.activo = true;
        this.valoracion = ThreadLocalRandom.current().nextInt(3, 6);
        this.especialidad = psicologo.especialidad();
        this.usuario = new Usuario(psicologo.usuario());
    }

    public void ActualizarPsicologo(ActualizarPsicologoDTO psicologoActualizado) {
        if (psicologoActualizado.nombre() != null) {
            this.nombre = psicologoActualizado.nombre();
        }
        if (psicologoActualizado.apellido() != null) {
            this.apellido = psicologoActualizado.apellido();
        }
        if (psicologoActualizado.email() != null) {
            this.email = psicologoActualizado.email();
        }
        if (psicologoActualizado.telefono() != null) {
            this.telefono = psicologoActualizado.telefono();
        }
        if (psicologoActualizado.documento() != null) {
            this.documento = psicologoActualizado.documento();
        }
        if (psicologoActualizado.descripcion() != null) {
            this.descripcion = psicologoActualizado.descripcion();
        }
        if (psicologoActualizado.especialidad() != null) {
            this.especialidad = psicologoActualizado.especialidad();
        }
    }
}
