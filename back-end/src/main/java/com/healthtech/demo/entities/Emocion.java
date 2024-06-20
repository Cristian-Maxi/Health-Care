package com.healthtech.demo.entities;

import com.healthtech.demo.dto.ActualizarEmocionDTO;
import com.healthtech.demo.dto.CrearEmocionDTO;
import com.healthtech.demo.enums.TipoEmocion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime; //Para mostrar la fecha y hora.
//import java.time.LocalDate; Para mostrar solo la fecha Ej: 2024-06-12


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    //@ElementCollection(targetClass = TipoEmocion.class) Usar esto si es una coleccion
    private TipoEmocion tipoEmocion;

    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;


    public Emocion(CrearEmocionDTO emocionDTO, Paciente paciente) {
        this.descripcion = emocionDTO.descripcion();
        this.fechaCreacion = LocalDateTime.now();
        this.tipoEmocion = emocionDTO.tipoEmocion();
        this.paciente = paciente;
    }

    public void ActualizarEmocion(ActualizarEmocionDTO emocionActualizada) {
        if (emocionActualizada.descripcion() != null) {
            this.descripcion = emocionActualizada.descripcion();
        }
        if (emocionActualizada.tipoEmocion() != null) {
            this.tipoEmocion = emocionActualizada.tipoEmocion();
        }
    }

}
