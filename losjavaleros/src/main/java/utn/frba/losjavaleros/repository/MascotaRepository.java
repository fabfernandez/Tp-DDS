package utn.frba.losjavaleros.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import lombok.Getter;
import lombok.Setter;
import utn.frba.losjavaleros.model.Mascota;
import utn.frba.losjavaleros.model.MascotaEstadoEnum;

@Repository
public class MascotaRepository {
  private final List<Mascota> mascotas=new ArrayList<>();

  public void guardar(Mascota mascota){
    mascotas.add(mascota);
  }

  public List<Mascota> getMascotas(){
     return mascotas;
  }

  public List<Mascota> getMascotasEstado(String estado){
   return mascotas.stream()
           .filter(mascota -> mascota.getEstado().equals(MascotaEstadoEnum.valueOf(estado)))
           .collect(Collectors.toList());
  }
}
