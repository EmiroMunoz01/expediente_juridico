package com.juridico.juridico.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.Set;


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
    @JoinColumn(name = "cliente_dni", nullable = false)
    private Cliente cliente;

    @ManyToMany(mappedBy = "asuntos")
    private Set<Procurador> procuradores;
}