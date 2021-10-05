package utn.frba.losjavaleros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.frba.losjavaleros.model.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {
}
