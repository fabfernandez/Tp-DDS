package utn.frba.losjavaleros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.frba.losjavaleros.model.Caracteristica;

@Repository
public interface CaracteristicaRepository extends JpaRepository<Caracteristica, Integer> {
}
