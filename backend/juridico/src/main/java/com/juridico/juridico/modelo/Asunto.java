package com.juridico.juridico.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "asunto")
public class Asunto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expediente;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_finalizacion")
    private Date fechaFinalizacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_asunto")
    private EstadoAsunto estado;

    @ManyToOne
    @JoinColumn(name = "dni_cliente", nullable = false)
    private Cliente cliente;

}