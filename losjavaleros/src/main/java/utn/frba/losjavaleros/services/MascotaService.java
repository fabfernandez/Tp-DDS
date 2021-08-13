package utn.frba.losjavaleros.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import utn.frba.losjavaleros.dto.MascotaDto;
import utn.frba.losjavaleros.model.Mascota;
import utn.frba.losjavaleros.model.Usuario;
import utn.frba.losjavaleros.repository.MascotaRepository;

@Service
public class MascotaService {

  private MascotaRepository mascotaRepository;

  public ResponseEntity crearMascota(final MascotaDto mascotaDto, final Usuario duenio) {

    //validaciones

    //crear la mascota
    Mascota mascota = new Mascota()

    //llamar repository
    mascotaRepository.guardar();

    return ResponseEntity.ok("ok");
  }
}
