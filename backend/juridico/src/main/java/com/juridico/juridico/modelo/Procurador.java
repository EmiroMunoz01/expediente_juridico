package com.juridico.juridico.modelo;

import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "procurador")
public class Procurador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String telefono;

    @ManyToMany
    @JoinTable(name = "procurador_asunto", joinColumns = @JoinColumn(name = "procurador_id"), inverseJoinColumns = @JoinColumn(name = "asunto_id"))
    private Set<Asunto> asuntos;
}
