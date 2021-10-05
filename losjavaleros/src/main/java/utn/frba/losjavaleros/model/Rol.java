package utn.frba.losjavaleros.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rol {

  @Id
  private Long id;

  private String nombre;

  @ManyToMany
  private List<Usuario> usuarios;

  public Rol(long l, String rol) {
    this.id = l;
    this.nombre = rol;
  }
}