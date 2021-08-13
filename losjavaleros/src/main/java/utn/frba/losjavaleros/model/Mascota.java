package utn.frba.losjavaleros.model;

import java.util.List;

import lombok.Data;

@Data
public class Mascota {
  private Usuario duenio;
  private List<CaracteristicaCompleta> caracteristicas;
  private String chapita;
  private String tipo;
  private String nombre;
  private String apodo;
  private Integer edad;
  private Sexo sexo;
  private String descripcion;
  private List<Foto> fotos;

  public Mascota(final Usuario duenio, final List<CaracteristicaCompleta> caracteristicas,
                 final String chapita,
                 final String tipo, final String nombre, final String apodo, final Integer edad, final Sexo sexo,
                 final String descripcion, final List<Foto> fotos) {
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
