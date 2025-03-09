//creamos la estructura que trae la respuesta de crear cliente

export interface Asunto {
  id: number;
  descripcion: string;
  estadoAsunto: string;
  fechaCreacion: number;
  clienteDni: number;
}
