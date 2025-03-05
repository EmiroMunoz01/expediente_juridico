package com.juridico.juridico.servicio.clienteService;

import java.util.List;

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
    public Cliente buscarClientePorId(Long id) {
        return clienteRepositorio.findById(id).orElse(null);
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        
        return clienteRepositorio.save(cliente);
    }

    @Override
    @Transactional
    public void eliminarClientePorDni(Integer dni) {
        clienteRepositorio.deleteByDni(dni);
    }

	@Override
	public void eliminarClientePorId(Long idCliente) {
		clienteRepositorio.deleteById(idCliente);
	}


    
}
