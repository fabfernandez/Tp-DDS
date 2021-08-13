package utn.frba.losjavaleros.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MascotaDto {

  private String nombre;
  private String apodo;
  private Integer edad;
  private String tipo;
  private String sexo;
  private String descripcion;
  private List<String> fotos;
  private List<CaracteristicaCompletaDto> caracteristicas;
}

