package com.juridico.juridico.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.juridico.juridico.modelo.Cliente;

public interface ClienteRepositorio extends CrudRepository<Cliente, Long> {

    Optional<Cliente> buscarClientePorDni(Integer dni);

}
