import { DatePipe } from '@angular/common';
import { Component, inject } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ClienteService } from '../servicios/cliente.service';
import { Cliente } from '../modelo/cliente.interface';

@Component({
  selector: 'app-cliente-listado',
  imports: [DatePipe, RouterModule],
  templateUrl: './cliente-listado.component.html',
  styleUrl: './cliente-listado.component.css',
})
export default class ClienteListadoComponent {

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

  eliminarCliente(cliente: Cliente) {
    this.clienteService.eliminar(cliente.dni).subscribe(() => {
      this.cargarTodo();
    });
  }

}
