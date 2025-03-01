package com.juridico.juridico.servicio.clienteService;


import java.util.List;
import java.util.Optional;

import com.juridico.juridico.modelo.Cliente;

public interface ICliente {

    public List<Cliente> listarClientes();

    public Optional<Cliente> buscarClientePorDni(Integer dni);

    public Cliente crearCliente(Cliente cliente);

    public void eliminarClientePorDni(Integer idCliente);

    public void actualizarClientePorDni(Integer idCliente);

}
