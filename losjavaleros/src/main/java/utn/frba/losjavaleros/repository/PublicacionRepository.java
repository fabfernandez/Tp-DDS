package utn.frba.losjavaleros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.frba.losjavaleros.model.Publicacion;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Integer> {
}
