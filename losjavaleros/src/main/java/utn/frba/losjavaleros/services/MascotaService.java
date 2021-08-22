package utn.frba.losjavaleros.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frba.losjavaleros.dto.MascotaDto;
import utn.frba.losjavaleros.model.*;
import utn.frba.losjavaleros.repository.MascotaRepository;

@Service
public class MascotaService {

  @Autowired
  private MascotaRepository mascotaRepository;

  public Mascota crearMascota(final MascotaDto mascotaDto, final Usuario duenio) {

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
        null, MascotaEstadoEnum.valueOf(mascotaDto.getEstado()));

    //guardar mascota
    mascotaRepository.guardar(mascota);

    return mascota;
  }

  public List<Mascota> filtrarMascotas(String estado){
     return mascotaRepository.getMascotasEstado(estado);
  }

  public Object mascotaEncontradaConChapita(final String formulario, final int mascotaId) {
    return null;
  }
}
