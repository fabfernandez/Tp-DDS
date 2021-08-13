package utn.frba.losjavaleros.model;

import lombok.AllArgsConstructor;
import lombok.Data;

//Entidad, pensado para que se puedan mantener N caracteristicas en base de datos
@Data
@AllArgsConstructor
public class Caracteristica {
  private String nombre;
  private String tipo; // ejemplo checkbox
}
