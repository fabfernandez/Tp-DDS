package utn.frba.losjavaleros.services;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import utn.frba.losjavaleros.dto.MascotaDto;
import utn.frba.losjavaleros.model.Caracteristica;
import utn.frba.losjavaleros.model.CaracteristicaCompleta;
import utn.frba.losjavaleros.model.Mascota;
import utn.frba.losjavaleros.model.Sexo;
import utn.frba.losjavaleros.model.Usuario;
import utn.frba.losjavaleros.repository.MascotaRepository;

@Service
public class MascotaService {

  private final MascotaRepository mascotaRepository;

  public MascotaService(final MascotaRepository mascotaRepository) {
    this.mascotaRepository = mascotaRepository;
  }

  public ResponseEntity crearMascota(final MascotaDto mascotaDto, final Usuario duenio) {

    Usuario duenioVacio = new Usuario();

    //Traer caracteristicas de base de datos por id
    Caracteristica caracteristicaDeBaseDeDatos = new Caracteristica("Color principal", "input");

    //insertar respuestas del usuario
    List<CaracteristicaCompleta> caracteristicas =
        List.of(new CaracteristicaCompleta(caracteristicaDeBaseDeDatos, "Rosa"));

    //crear fotos???

    //crear la mascota
    Mascota mascota = new Mascota(
        duenioVacio,
        caracteristicas,
        UUID.randomUUID().toString(),
        mascotaDto.getTipo(),
        mascotaDto.getNombre(),
        mascotaDto.getApodo(),
        mascotaDto.getEdad(),
        Sexo.valueOf(mascotaDto.getSexo()),
        mascotaDto.getDescripcion(),
        null);

    //guardar mascota
    mascotaRepository.guardar(mascota);

    return ResponseEntity.ok("ok");
  }
}
