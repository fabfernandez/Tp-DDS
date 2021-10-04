package utn.frba.losjavaleros.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;
import utn.frba.losjavaleros.helpers.JsonHelper;
import utn.frba.losjavaleros.model.Usuario;

import javax.annotation.PostConstruct;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UsuarioRepository {

  private List<Usuario> usuarios;

  @PostConstruct
  public void init() throws IOException {
    String file = "Users.json";
    String json = new String(Files.readAllBytes(Paths.get(file)));
    TypeReference typeReference = new TypeReference<List<Usuario>>() {
    };
    usuarios = (List<Usuario>) JsonHelper.parse(json, typeReference);

  }

  public Usuario findByUsername(String usuario) {
    return usuarios.stream().filter(user -> user.getNombreUsuario().equals(usuario)).findFirst().orElse(null);
  }

  public void addUser(Usuario user) {
    usuarios.add(user);
  }

  public Usuario findById(final int usuarioId) {
    Optional<Usuario> usuarioOptional =
        usuarios.stream()
            .filter(usuario -> usuario.getId() == usuarioId).collect(Collectors.toList()).stream()
            .findFirst();
    if (usuarioOptional.isPresent()) {
      return usuarioOptional.get();

    } else throw new RuntimeException(String.format("Usuario id %s no encontrada.", usuarioId));

  }

}
