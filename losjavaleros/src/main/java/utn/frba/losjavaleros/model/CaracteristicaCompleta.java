package utn.frba.losjavaleros.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Caracteristica guardada dentro de una Mascota.
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class CaracteristicaCompleta {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  private Caracteristica caracteristica;
  private String respuesta;
}
