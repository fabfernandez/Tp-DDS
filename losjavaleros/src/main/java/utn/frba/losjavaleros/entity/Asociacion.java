package utn.frba.losjavaleros.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Asociacion {
  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  private String nombre;

  public Asociacion() {
  }
}
