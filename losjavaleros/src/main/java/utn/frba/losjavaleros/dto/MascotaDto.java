package utn.frba.losjavaleros.dto;

import java.util.List;

import lombok.Data;

@Data
public class MascotaDto {

  private String nombre;
  private String apodo;
  private Integer edad;
  private String tipo;
  private String sexo;
  private String descripcion;
  private List<String> fotos;
  private List<CaracteristicaDto> caracteristicas;
}

