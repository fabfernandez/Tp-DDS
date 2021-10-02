package utn.frba.losjavaleros.model;

import java.util.Collection;
import java.util.List;

public class Voluntario extends Usuario {
  public Voluntario(Usuario usuario) {
    super(usuario.getId(), usuario.getDni(), usuario.getNombreUsuario(), usuario.getNombre(), usuario.getApellido(),
        usuario.getEmail(), usuario.getContrasenia(), usuario.getRoles(), usuario.getMascotas());
  }

  public Voluntario(final Integer id, final Long dni, final String nombreUsuario, final String nombre, final String apellido, final String email, final String contrasenia, final Collection<Rol> roles, final List<Mascota> mascotas) {
    super(id, dni, nombreUsuario, nombre, apellido, email, contrasenia, roles, mascotas);
  }
}
