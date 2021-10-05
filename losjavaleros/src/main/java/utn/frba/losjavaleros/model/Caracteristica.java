package utn.frba.losjavaleros.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Entidad, pensado para que se puedan mantener N caracteristicas en base de datos
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Caracteristica {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String nombre;  // Ejemplo: "Ingrese el color principal de su mascota" o "Esta castrado? SI/NO"
  private String tipo; // El tipo de respuesta, puede ser texto o booleano
}
