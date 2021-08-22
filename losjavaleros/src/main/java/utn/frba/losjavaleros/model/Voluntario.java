package utn.frba.losjavaleros.model;

import lombok.SneakyThrows;

public class Voluntario extends Usuario {

  @SneakyThrows
  public Voluntario(final Usuario usuario) {
    super(usuario.getDni(), usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getContrasenia(),
        usuario.getRoles());
  }
}
