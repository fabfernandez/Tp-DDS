package utn.frba.losjavaleros.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import lombok.Getter;
import lombok.Setter;
import utn.frba.losjavaleros.model.Mascota;

@Repository
@Getter
@Setter
public class MascotaRepository {
  private List<Mascota> mascotas;

  public void guardar(Mascota mascota){
    mascotas.add(mascota);
  }
}
