package utn.frba.losjavaleros.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import utn.frba.losjavaleros.model.JoinColumn;
import utn.frba.losjavaleros.model.JoinTable;
import utn.frba.losjavaleros.model.ManyToMany;
import utn.frba.losjavaleros.model.Mascota;
import utn.frba.losjavaleros.model.OneToMany;
import utn.frba.losjavaleros.model.Rol;
import utn.frba.losjavaleros.model.Usuario;

@Setter
@Getter
public class UsuarioDto {
//  private String name;
//  private String apellido;
//  private String fechaNacimiento;
//  private Long dni;
//  private ContactoDto contactoPrincipal;
//  private List<ContactoDto> contactosSecundarios;
//  private String contrasenia;
//  private String nombreUsuario;
//  private String email;
//  private Collection<Rol> roles;
  
  
  
  private Integer id;
  private Long dni;
  private String nombreUsuario;
  private String nombre;
  private String apellido;
  private String email;
  private String contrasenia;
  private Collection<RolDto> roles;
  private List<MascotaDto> mascotas;
  
  
public UsuarioDto(Usuario usuario) {
	
	this.id = usuario.getId();
	this.nombreUsuario = usuario.getNombreUsuario();
	this.nombre = usuario.getNombre();
	this.apellido = usuario.getApellido();
	this.email = usuario.getEmail();
	this.contrasenia = usuario.getContrasenia();
	
	
	
	for (Rol rol: usuario.getRoles()) {
		RolDto a = new RolDto(rol);
		this.roles.add(a);
	}
	
	for (Mascota mascota: usuario.getMascotas()) {
		MascotaDto mata = new MascotaDto(mascota);
		this.mascotas.add(mata);
	}
	
	
	
}
  
  
  
  
  
  
  
  

}
