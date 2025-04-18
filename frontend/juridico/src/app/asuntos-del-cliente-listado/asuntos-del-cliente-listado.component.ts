import { Component, inject, OnInit } from '@angular/core';
import { DatePipe, NgFor, NgIf } from '@angular/common';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { ClienteService } from '../servicios/cliente.service';
import { Asunto } from '../modelo/asunto.interface';
import { Cliente } from '../modelo/cliente.interface';

@Component({
  selector: 'app-asuntos-del-cliente-listado',
  imports: [RouterModule, DatePipe],
  templateUrl: './asuntos-del-cliente-listado.component.html',
  styleUrl: './asuntos-del-cliente-listado.component.css',
})
export default class AsuntosDelClienteListadoComponent implements OnInit {
  private route = inject(ActivatedRoute);

  asuntos: Asunto[] = [];



  dniString = this.route.snapshot.paramMap.get('dni');
  dni = this.dniString ? Number(this.dniString) : null;

  cliente: Cliente | undefined;

  private clientesService = inject(ClienteService);

  ngOnInit() {
    if (this.dni) {
      this.cargarAsuntos();
      this.cargarCliente();
    }
  }

  cargarCliente() {
    this.clientesService.obtenerClientePorDni(this.dni!).subscribe({
      next: (data) => {
        this.cliente = data; // Asegúrate de que 'asuntos' está definido en tu componente
      },
      error: (error) => {
        console.error('Error al obtener los asuntos:', error);
      },
    });
  }

  cargarAsuntos() {
    this.clientesService.listarAsuntosCliente(this.dni!).subscribe({
      next: (data) => {
        this.asuntos = data; // Asegúrate de que 'asuntos' está definido en tu componente
      },
      error: (error) => {
        console.error('Error al obtener los asuntos:', error);
      },
    });
  }
}
