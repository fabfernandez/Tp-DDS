package utn.frba.losjavaleros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.frba.losjavaleros.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}
