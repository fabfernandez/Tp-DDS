package utn.frba.losjavaleros.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frba.losjavaleros.dto.CaracteristicaCompletaDto;
import utn.frba.losjavaleros.dto.FormMascotaConChapitaDto;
import utn.frba.losjavaleros.dto.MascotaDto;
import utn.frba.losjavaleros.dto.UsuarioDto;
import utn.frba.losjavaleros.model.*;
import utn.frba.losjavaleros.repository.MascotaRepository;

@Service
public class MascotaService {

  @Autowired
  private MascotaRepository mascotaRepository;

  @Autowired
  private EnviadorDeMails enviadorDeMails;

  public Mascota crearMascota(final MascotaDto mascotaDto, final Usuario duenio) {

    List<CaracteristicaCompleta> caracteristicasCompletas = new ArrayList<>();

    //Iterando las caracteristicas completas que vienen en el mascotaDto:
    List<CaracteristicaCompletaDto> caracteristicaCompletaDtos = mascotaDto.getCaracteristicas();
    for (CaracteristicaCompletaDto caracteristicaCompletaDto : caracteristicaCompletaDtos) {

      //1. TODO Traer caracteristica de base de datos por id
      Caracteristica caracteristicaDeBaseDeDatos = new Caracteristica(caracteristicaCompletaDto.getIdCaracteristica(), "Color" +
          "principal", "input");
      //2. Insertar respuestas del usuario
      Caracteristica caracteristica = new Caracteristica(caracteristicaCompletaDto.getIdCaracteristica(),
          caracteristicaDeBaseDeDatos.getNombre(),
          caracteristicaDeBaseDeDatos.getTipo());

      caracteristicasCompletas.add(new CaracteristicaCompleta(
          caracteristicaCompletaDto.getIdCaracteristica(), caracteristica, caracteristicaCompletaDto.getRespuesta())
      );

    }

    //TODO crear fotos???

    //crear la mascota
    Mascota mascota = new Mascota(
        1, //TODO ESTE VALOR DEBE SER AUTO INCREMENTAL.
        duenio,
        caracteristicasCompletas,
        UUID.randomUUID().toString(),
        mascotaDto.getTipo(),
        mascotaDto.getNombre(),
        mascotaDto.getApodo(),
        mascotaDto.getEdad(),
        Sexo.valueOf(mascotaDto.getSexo()),
        mascotaDto.getDescripcion(),
        null, MascotaEstadoEnum.valueOf(mascotaDto.getEstado()));

    //guardar mascota
    mascotaRepository.save(mascota);
    duenio.getMascotas().add(mascota);

    return mascota;
  }

  public List<Mascota> filtrarMascotas(String estado) {
    return mascotaRepository.findAll().stream().filter(mascota -> Objects.equals(mascota.getEstado().toString(), estado)).collect(Collectors.toList());
  }

  public void notificarSobreMascotaEncontrada(final FormMascotaConChapitaDto formulario, final int mascotaId) {
    /*
     * Una vez completado el formulario, el sistema deberá notificarle de esta situación al dueño
     * (conocido por estar ligado a la chapita) mediante los medios de notificación preferidos.*/
    Mascota mascota = mascotaRepository.getById(mascotaId);
    String nombreMascota = mascota.getNombre();

    Usuario duenio = mascota.getDuenio();
    String email = duenio.getEmail();
    String nombreDuenio = duenio.getNombre();

    UsuarioDto rescatista = formulario.getUsuarioDto();
    String nombreRescatista = rescatista.getNombreUsuario();
    String apellidoRescatista = rescatista.getApellido();

    String cuerpoEmail = String.format("Hola %s, una persona llamada %s %s encontró a tu mascota %s",
        nombreDuenio, nombreRescatista, apellidoRescatista, nombreMascota);
    enviadorDeMails.enviarMail(email, "Alguien encontro a tu mascota!", cuerpoEmail);
  }

  public Mascota getMascotaById(int id) {
    return mascotaRepository.getById(id);
  }

}
