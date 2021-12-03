package utn.frba.losjavaleros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.frba.losjavaleros.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

   Usuario findByNombreUsuario(String usuario);

   Usuario findById(int usuarioId);

}
