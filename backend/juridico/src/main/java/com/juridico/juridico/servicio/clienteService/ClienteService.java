package com.juridico.juridico.servicio.clienteService;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juridico.juridico.modelo.Cliente;
import com.juridico.juridico.repositorio.ClienteRepository;

@Service
public class ClienteService implements ICliente{


    @Autowired
    private ClienteRepository clienteRepositorio;


    @Override
    public List<Cliente> listarClientes() {
        return (List<Cliente>) clienteRepositorio.findAll();
    }

    @Override
    public Optional<Cliente> buscarClientePorDni(Integer dni) {
        return clienteRepositorio.buscarClientePorDni(dni);
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public void eliminarClientePorDni(Integer dniCliente) {
        clienteRepositorio.buscarClientePorDni(dniCliente);
    }

    @Override
    public void actualizarClientePorDni(Integer dniCliente) {
        Optional<Cliente> cliente = clienteRepositorio.buscarClientePorDni(dniCliente);


    }
}
