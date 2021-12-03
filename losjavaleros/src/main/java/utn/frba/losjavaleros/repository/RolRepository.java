package utn.frba.losjavaleros.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.frba.losjavaleros.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
  Optional<Rol> findById(Long rolId);
}
