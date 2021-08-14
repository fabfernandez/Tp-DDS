package utn.frba.losjavaleros.dto;

import java.util.Collection;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import utn.frba.losjavaleros.model.Rol;

@Setter
@Getter
public class UsuarioDto {
  private String name;
  private String apellido;
  private String fechaNacimiento;
  private Long dni;
  private ContactoDto contactoPrincipal;
  private List<ContactoDto> contactosSecundarios;
  private String contrasenia;
  private String nombreUsuario;
  private String email;
  private Collection<Rol> roles;

}
