package com.juridico.juridico.modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "asunto_procurador")
public class AsuntoProcurador {

    @Id
    @ManyToOne
    @JoinColumn(name = "expediente", nullable = false)
    private Asunto asunto;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_procurador", nullable = false)
    private Procurador procurador;
}
