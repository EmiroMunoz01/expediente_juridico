package com.juridico.juridico.servicio.clienteService;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juridico.juridico.modelo.Cliente;
import com.juridico.juridico.repositorio.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService implements ICliente {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    public Cliente buscarClientePorDni(Long dni) {
        return clienteRepository.findByDni(dni);
    }

    @Override
    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        cliente.setFechaCreacion(LocalDateTime.now());
        return clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public void eliminarClientePorDni(Long dni) {
        clienteRepository.deleteByDni(dni);
    }

    @Override
    public void eliminarClientePorId(Long idCliente) {
        clienteRepository.deleteById(idCliente);
    }


    @Override
    public Cliente actualizarCliente(Long dni, Cliente cliente) {
        // Validar que el cliente proporcionado no sea nulo

        Cliente clienteEnSQL = clienteRepository.findByDni(dni);

        System.out.println(clienteEnSQL);


        if (clienteEnSQL != null) {

            clienteEnSQL.setNombre(cliente.getNombre());
            clienteEnSQL.setUbicacion(cliente.getUbicacion());
            clienteEnSQL.setTelefono(cliente.getTelefono());

            System.out.println("Cliente modificado por DNI");

            return this.clienteRepository.save(clienteEnSQL);

        } else {
            System.out.println("no ha pasado nadota");
            return null;
        }

    }

}
