package com.juridico.juridico.controlador;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juridico.juridico.modelo.Cliente;
import com.juridico.juridico.servicio.clienteService.ClienteService;

@RestController
@RequestMapping("juridico-app")

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes/obtener-clientes")
    public List<Cliente> listarEntrenadores() {
        return clienteService.listarClientes();
    }

    @GetMapping("/clientes/buscar-por-dni/{dniCliente}")
    public Optional<Cliente> buscarClientePorDni(@PathVariable Integer dniCliente) {
        return clienteService.buscarClientePorDni(dniCliente);
    }

    @PostMapping("/clientes/crear-cliente")
    public Cliente crearCliente(@RequestBody Cliente cliente) {

        cliente.setFechaCreacion(LocalDate.now());
        return clienteService.crearCliente(cliente);
    }

}
