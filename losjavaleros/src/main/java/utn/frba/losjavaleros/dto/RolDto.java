package utn.frba.losjavaleros.dto;

import java.util.List;

import utn.frba.losjavaleros.model.Rol;
import utn.frba.losjavaleros.model.Usuario;

public class RolDto {
	
	  private Long id;
	  private String nombre;
	  private List<Usuario> usuarios;
	
	  
	  
	  public RolDto(Rol rol) {

		  this.id = rol.getId();
		  this.nombre = rol.getNombre();
	  
	  }
	  
	  

}
