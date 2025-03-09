import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Cliente } from '../modelo/cliente.interface';

@Injectable({
  providedIn: 'root',
})
export class ClienteService {
  private http = inject(HttpClient);

  listarClientes() {
    return this.http.get<Cliente[]>(
      `http://localhost:8080/juridico-app/clientes/obtener-clientes`
    );
  }

  obtenerClientePorDni(dni: number) {
    return this.http.get<Cliente>(
      `http://localhost:8080/juridico-app/clientes/buscar-por-dni/${dni}`
    );
  }

  obtenerClientePorId(id: number) {
    return this.http.get<Cliente>(
      `http://localhost:8080/juridico-app/clientes/buscar-por-dni/${id}`
    );
  }

  crearCliente(cliente: Cliente) {
    return this.http.post<Cliente>(
      `http://localhost:8080/juridico-app/clientes/crear-cliente`,
      cliente
    );
  }

  actualizarCliente(dni: number, cliente: Cliente) {
    return this.http.put<Cliente>(
      `http://localhost:8080/juridico-app/clientes/actualizar-cliente/${dni}`,
      cliente
    );
  }

  eliminar(dni: number) {
    return this.http.delete<void>(
      `http://localhost:8080/juridico-app/clientes/eliminar-cliente-por-dni/${dni}`
    );
  }

  listarAsuntosCliente(dni: number) {
    return this.http.get<Cliente>(
      `http://localhost:8080/juridico-app/clientes/${dni}/asuntos`
    );
  }
  
}
