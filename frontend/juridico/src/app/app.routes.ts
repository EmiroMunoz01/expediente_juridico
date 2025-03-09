import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () => import('./pagina-inicial/pagina-inicial.component'),
  },
  {
    path: 'clientes',
    loadComponent: () => import('./cliente-listado/cliente-listado.component'),
  },
  {
    path: 'clientes/nuevo',
    loadComponent: () => import('./cliente-formulario/cliente-formulario.component'),
  },
  {
    path: 'clientes/:dni/actualizar',
    loadComponent: () => import('./cliente-formulario/cliente-formulario.component'),
  },{
    path: 'clientes/:dni/asuntos',
    loadComponent: () => import('./cliente-formulario/cliente-formulario.component'),
  },
];
