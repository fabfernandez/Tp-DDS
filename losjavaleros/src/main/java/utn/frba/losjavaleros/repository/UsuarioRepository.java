package utn.frba.losjavaleros.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.data.jpa.repository.JpaRepository;
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
public interface UsuarioRepository extends JpaRepository {

/*
  @PostConstruct
  public void init() throws IOException {
    String file = "Users.json";
    String json = new String(Files.readAllBytes(Paths.get(file)));
    TypeReference typeReference = new TypeReference<List<Usuario>>() {
    };
    usuarios = (List<Usuario>) JsonHelper.parse(json, typeReference);

  }
*/

   Usuario findByUsername(String usuario);

   Usuario save(Usuario usuario);

   Usuario findById(int usuarioId);



}
