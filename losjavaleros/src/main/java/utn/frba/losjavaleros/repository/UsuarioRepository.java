package utn.frba.losjavaleros.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import utn.frba.losjavaleros.model.Usuario;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Integer> {

   Usuario findByNombreUsuario(String usuario);

   Usuario save(Usuario usuario);

   Usuario findById(int usuarioId);

}
