package utn.frba.losjavaleros.model;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class Mascota {
  private String id;
  private Usuario duenio;
  private List<Caracteristica> caracteristicas;
  private Chapita chapita;
  private String tipo;
  private String nombre;
  private String apodo;
  private Integer edad;
  private Sexo sexo;
  private String descripcion;
  private List<Foto> fotos;

  public Mascota(final Usuario duenio, final List<Caracteristica> caracteristicas, final Chapita chapita, final String tipo, final String nombre, final String apodo, final Integer edad, final Sexo sexo, final String descripcion, final List<Foto> fotos) {
    this.id = UUID.randomUUID().toString();
    this.duenio = duenio;
    this.caracteristicas = caracteristicas;
    this.chapita = chapita;
    this.tipo = tipo;
    this.nombre = nombre;
    this.apodo = apodo;
    this.edad = edad;
    this.sexo = sexo;
    this.descripcion = descripcion;
    this.fotos = fotos;
  }
}
