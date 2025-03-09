//creamos la estructura que trae la respuesta de crear cliente

import { Asunto } from "./asunto.interface";

export interface Cliente {
  dni: number;
  nombre: string;
  ubicacion: string;
  telefono: number;
  asuntos: Asunto[]; // Define correctamente el tipo de 'asuntos'
  fechaCreacion: string;
}
