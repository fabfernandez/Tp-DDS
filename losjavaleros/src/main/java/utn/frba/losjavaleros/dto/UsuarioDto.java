package utn.frba.losjavaleros.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class UsuarioDto {
  private String name;
  private String apellido;
  private String fechaNacimiento;
  private Long dni;
  private ContactoDto contactoPrincipal;
  private List<ContactoDto> contactosSecundarios;
  private String contrasenia;

}
