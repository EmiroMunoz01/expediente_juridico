package com.juridico.juridico.controlador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juridico.juridico.modelo.Cliente;
import com.juridico.juridico.servicio.clienteService.ClienteService;

@RestController
@RequestMapping("juridico-app")
@CrossOrigin(value = "http://localhost:4200")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // metodo para listar todos los clientes
    @GetMapping("/clientes/obtener-clientes")
    public List<Cliente> listarEntrenadores() {
        return clienteService.listarClientes();
    }

    // metodo para filtrar un cliente por id
    @GetMapping("/clientes/buscar-por-id/{id}")
    public Cliente buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id);
    }

    // metodo para filtrar un cliente por dni
    @GetMapping("/clientes/buscar-por-dni/{dniCliente}")
    public Cliente buscarClientePorDni(@PathVariable Integer dniCliente) {
        return clienteService.buscarClientePorDni(dniCliente);
    }

    // metodo para crear un cliente
    @PostMapping("/clientes/crear-cliente")
    public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente) {

        Cliente clienteVerificacion = clienteService.buscarClientePorDni(cliente.getDni());

        try {
            if (clienteVerificacion != null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("El cliente ya existe, la peticion es erronea.");
            } else {
                cliente.setFechaCreacion(LocalDateTime.now());
                clienteService.crearCliente(cliente);
                return ResponseEntity.ok(cliente);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error al momento de realizar la peticion, puede existir un valor duplicado.");
        }
    }

    // metodo para eliminar un cliente por dni
    @DeleteMapping("/clientes/eliminar-cliente-por-dni/{dni}")
    public void eliminarClientePorDNI(@PathVariable Integer dni) {
        clienteService.eliminarClientePorDni(dni);
    }

    @DeleteMapping("/clientes/eliminar-cliente-por-id/{id}")
    public void eliminarClientePorID(@PathVariable Long id) {
        clienteService.eliminarClientePorId(id);
    }

    // metodo para actualizar un cliente por dni
    @PutMapping("/clientes/actualizar-cliente/{dni}")
    public ResponseEntity<?> actualizarCliente(@PathVariable Integer dni,
            @RequestBody Cliente clienteActualizado) {

        Cliente clienteBase = clienteService.buscarClientePorDni(dni);

        try {
            if (clienteBase != null) {
                clienteBase.setDni(clienteActualizado.getDni());
                clienteBase.setNombre(clienteActualizado.getNombre());
                clienteBase.setDireccion(clienteActualizado.getDireccion());
                clienteBase.setDni(clienteActualizado.getDni());
                clienteBase.setTelefono(clienteActualizado.getTelefono());

                clienteService.actualizarCliente(clienteBase);

                return ResponseEntity.ok(clienteBase);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El cliente no existe, primero debes crearlo.");
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error al momento de realizar la peticion, puede existir un valor duplicado.");
        }

    }
}
