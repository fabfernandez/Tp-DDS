package utn.frba.losjavaleros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.frba.losjavaleros.model.Voluntario;

@Repository
public interface VoluntarioRepository  extends JpaRepository<Voluntario, Integer>{
}
