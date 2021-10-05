package utn.frba.losjavaleros.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MascotaDto {

  private String nombre;
  private String apodo;
  private Integer edad;
  private String tipo;
  private String sexo;
  private String descripcion;
  private List<String> fotos;
  private List<CaracteristicaCompletaDto> caracteristicas;
  private String estado;
}

