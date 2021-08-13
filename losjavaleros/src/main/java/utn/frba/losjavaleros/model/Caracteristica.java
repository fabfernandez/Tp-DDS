package utn.frba.losjavaleros.model;

import lombok.AllArgsConstructor;
import lombok.Data;

//Entidad, pensado para que se puedan mantener N caracteristicas en base de datos
@Data
@AllArgsConstructor
public class Caracteristica {
  private String nombre;  // Ejemplo: "Ingrese el color principal de su mascota" o "Esta castrado? SI/NO"
  private String tipo; // El tipo de respuesta, puede ser texto o booleano
}
