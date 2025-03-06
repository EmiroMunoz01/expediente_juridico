package com.juridico.juridico.servicio.asuntoService;

import java.util.List;

import com.juridico.juridico.modelo.Asunto;

public interface IAsunto {

    public Asunto crearAsunto(Asunto asunto);

    public List<Asunto> listarAsuntos();

    public Asunto buscarAsuntoPorId(Long idAsunto);

    public void eliminarAsuntoPorId(Long idAsunto);

    public Asunto actualizarAsunto(Asunto asunto);

}
