import { Component, inject } from '@angular/core';
import { Cliente } from '../modelo/cliente.interface';
import { DatePipe } from '@angular/common';
import { RouterModule } from '@angular/router';
import { ClienteService } from '../servicios/cliente.service';

@Component({
  selector: 'app-asuntos-del-cliente-listado',
  imports: [DatePipe, RouterModule],
  templateUrl: './asuntos-del-cliente-listado.component.html',
  styleUrl: './asuntos-del-cliente-listado.component.css',
})
export default class AsuntosDelClienteListadoComponent {


    private clienteService = inject(ClienteService);

    clientesArrayAsuntos: Cliente[] = [];



}
