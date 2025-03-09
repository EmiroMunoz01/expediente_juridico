import { Component, inject } from '@angular/core';
import { DatePipe } from '@angular/common';
import { RouterLink } from '@angular/router';
import { Cliente } from '../modelo/cliente.interface';
import { ClienteService } from '../servicios/cliente.service';

@Component({
  selector: 'app-cliente-asuntos-listado',
  imports: [DatePipe, RouterLink],
  templateUrl: './cliente-asuntos-listado.component.html',
  styleUrl: './cliente-asuntos-listado.component.css',
})
export default class ClienteAsuntosListadoComponent {
  private clienteService = inject(ClienteService);
  clientesArray: Cliente[] = [];

  ngOnInit(): void {
    this.cargarTodo();
  }

  cargarTodo() {
    this.clienteService.listarClientes().subscribe((clientes) => {
      this.clientesArray = clientes;
    });
  }
}
