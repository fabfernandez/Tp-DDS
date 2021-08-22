package utn.frba.losjavaleros.model;

import java.util.Collection;

import utn.frba.losjavaleros.model.exception.InvalidPasswordException;

public class Voluntario extends Usuario {

	public Voluntario(Long dni, String firstName, String lastName, String email, String contrasenia,
			Collection<Rol> roles) throws InvalidPasswordException {
		super(dni, firstName, lastName, email, contrasenia, roles);
		// TODO Auto-generated constructor stub
	}
	
	

}
