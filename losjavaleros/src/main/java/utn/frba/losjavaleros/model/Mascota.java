package utn.frba.losjavaleros.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
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
  private MascotaEstadoEnum estado;

}
