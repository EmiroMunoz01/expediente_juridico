package com.juridico.juridico.servicio.clienteService;


import java.util.List;
import java.util.Optional;

import com.juridico.juridico.modelo.Cliente;

public interface ICliente {

    public List<Cliente> listarClientes();

    public Cliente buscarClientePorDni(Integer dniCliente);

    public Cliente crearCliente(Cliente cliente);

    public void eliminarClientePorDni(Integer dniCliente);

    public void actualizarClientePorDni(Integer dniCliente);

}
