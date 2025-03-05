import { Component, inject, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';

import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ClienteService } from '../servicios/cliente.service';
import { Cliente } from '../modelo/cliente.interface';

@Component({
  selector: 'app-cliente-formulario',
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './cliente-formulario.component.html',
  styleUrl: './cliente-formulario.component.css',
})
export default class ClienteFormularioComponent implements OnInit {
  
  private fb = inject(FormBuilder);

  private clienteServicio = inject(ClienteService);

  private router = inject(Router);
  private route = inject(ActivatedRoute);

  form?: FormGroup;
  clienteValidador?: Cliente;

  ngOnInit(): void {
    const dni = this.route.snapshot.paramMap.get('dni');

    if (dni) {
      this.clienteServicio
        .obtenerClientePorDni(parseInt(dni))
        .subscribe((cliente) => {
          this.clienteValidador = cliente;

          this.form = this.fb.group({
            dni: [cliente.dni, [Validators.required]],
            nombre: [cliente.nombre, [Validators.required]],
            telefono: [cliente.telefono, [Validators.required]],
          });

        });
    } else {
      this.form = this.fb.group({
        dni: ['', [Validators.required]],
        nombre: ['', [Validators.required]],
        telefono: ['', [Validators.required]],
      });
    }
  }

  guardar() {
    if (this.form?.invalid) {
      return;
    }

    const clienteFormulario = this.form!.value;

    if (this.clienteValidador) {
      console.log("");
      this.clienteServicio
        .actualizarCliente(this.clienteValidador.dni, clienteFormulario)
        .subscribe(() => {
          this.router.navigate(['/clientes']);
        });
    } else {
      this.clienteServicio.crearCliente(clienteFormulario).subscribe(() => {
        this.router.navigate(['/clientes']);
      });
    }
  }
}
