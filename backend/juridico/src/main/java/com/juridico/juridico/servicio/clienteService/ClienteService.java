package com.juridico.juridico.servicio.clienteService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juridico.juridico.modelo.Cliente;
import com.juridico.juridico.repositorio.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService implements ICliente {

    @Autowired
    private ClienteRepository clienteRepositorio;

    @Override
    public List<Cliente> listarClientes() {
        return (List<Cliente>) clienteRepositorio.findAll();
    }

    @Override
    public Cliente buscarClientePorDni(Integer dni) {
        return clienteRepositorio.findByDni(dni);
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(Integer dniCliente, Cliente cliente) {

        Cliente clienteBD = clienteRepositorio.findByDni(dniCliente);

        if (clienteBD != null) {
            
            clienteBD.setDni(cliente.getDni());
            clienteBD.setFechaCreacion(cliente.getFechaCreacion());
            clienteBD.setDireccion(cliente.getDireccion());
            clienteBD.setTelefono(cliente.getTelefono());
            return clienteRepositorio.save(clienteBD);

        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void eliminarClientePorDni(Integer dni) {
        clienteRepositorio.deleteByDni(dni);
    }

}
