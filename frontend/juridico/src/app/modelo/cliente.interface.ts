//creamos la estructura que trae la respuesta de crear cliente

export interface Cliente {
  dni: number;
  nombre: string;
  direccion: string;
  telefono: number;
  fechaCreacion: string;
}
