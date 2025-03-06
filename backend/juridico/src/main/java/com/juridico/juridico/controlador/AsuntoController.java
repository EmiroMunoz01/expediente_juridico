package com.juridico.juridico.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juridico.juridico.modelo.Asunto;
import com.juridico.juridico.servicio.asuntoService.AsuntoService;

@RestController
@RequestMapping()
public class AsuntoController {

    @Autowired
    private AsuntoService asuntoService;

    // metodo para listar todos los asuntos existentes
    @GetMapping("/asuntos/obtener-asuntos")
    public List<Asunto> listarAsuntos() {
        return asuntoService.listarAsuntos();
    }

    // metodo para listar un asunto por id
    @GetMapping("/asuntos/buscar-por-id/{id}")
    public Asunto buscarAsuntoPorId(@PathVariable Long id) {
        return asuntoService.buscarAsuntoPorId(id);
    }

    // metodo para crear un asunto

    @SuppressWarnings("null")
    @PostMapping("/asuntos/crear-asunto")
    public ResponseEntity<?> crearAsunto(@RequestBody Asunto asunto) {

        // el expediente es el equivalente al ID para nosotros
        Asunto asuntoVerificar = asuntoService.buscarAsuntoPorId(asunto.getExpediente());

        try {
            if (asuntoVerificar != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El cliente ya existe, la peticion es erronea.");
            } else {
                asuntoVerificar.setEstado(asunto.getEstado());
                asuntoVerificar.setCliente(asunto.getCliente());
                asuntoVerificar.setDescripcion(asunto.getDescripcion());
                asuntoVerificar.setFechaCreacion(asunto.getFechaCreacion());
                asuntoVerificar.setFechaFinalizacion(asunto.getFechaFinalizacion());
                asuntoVerificar.setProcuradores(asunto.getProcuradores());
                asuntoService.crearAsunto(asuntoVerificar);
                return ResponseEntity.ok(asuntoVerificar);
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error al momento de realizar la peticion, puede existir un valor duplicado.");
        }

    }

    @PutMapping("/asuntos/actualizar-asunto/{expediente}")
    public ResponseEntity<?> actualizarAsunto(@PathVariable Long expediente, @RequestBody Asunto asuntoBase) {

        Asunto asunto = asuntoService.buscarAsuntoPorId(asuntoBase.getExpediente());

        try {
            if (asunto != null) {
                asunto.setDescripcion(asuntoBase.getDescripcion());
                asuntoService.actualizarAsunto(asunto);
                return ResponseEntity.ok(asunto);
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El cliente no existe, primero debes crearlo.");
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error al momento de realizar la peticion, puede existir un valor duplicado.");
        }

    }
}
