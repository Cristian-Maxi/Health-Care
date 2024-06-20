package com.healthtech.demo.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "psicologo_id")
    private Psicologo psicologo; // Relación uno a uno con Psicologo

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente; // Relación uno a uno con Paciente

    private LocalDateTime fecha;
    
    private String linkVideollamada; //NUEVO CODIGO PARA GENERAR LINK VIDEO LLAMADA

    public Consulta(Psicologo psicologo, Paciente paciente, LocalDateTime fecha, String link) {
        this.psicologo = psicologo;
        this.paciente = paciente;
        this.fecha = fecha;
        this.linkVideollamada = link; //NUEVO CODIGO PARA GENERAR LINK VIDEO LLAMADA
    }
}

