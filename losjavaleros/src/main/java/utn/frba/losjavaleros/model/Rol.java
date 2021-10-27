package utn.frba.losjavaleros.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Rol {

  @Id
  private Long id;

  private String nombre;

  public Rol(Long id, String rol) {
    this.nombre = rol;
    this.id = id;
  }

  public Rol() {
  }
}