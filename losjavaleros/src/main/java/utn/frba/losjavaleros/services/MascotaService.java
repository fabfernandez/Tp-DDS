package utn.frba.losjavaleros.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import utn.frba.losjavaleros.dto.CaracteristicaCompletaDto;
import utn.frba.losjavaleros.dto.FormMascotaConChapitaDto;
import utn.frba.losjavaleros.dto.MascotaDto;
import utn.frba.losjavaleros.dto.UsuarioDto;
import utn.frba.losjavaleros.model.*;
import utn.frba.losjavaleros.repository.CaracteristicaCompletaRepository;
import utn.frba.losjavaleros.repository.CaracteristicaRepository;
import utn.frba.losjavaleros.repository.MascotaRepository;

@Service
public class MascotaService {

  @Autowired
  private MascotaRepository mascotaRepository;

  @Autowired
  private EnviadorDeMails enviadorDeMails;

  @Autowired
  private CaracteristicaRepository caracteristicaRepository;

  @Autowired
  private CaracteristicaCompletaRepository caracteristicaCompletaRepository;

  public void crearMascota(final MascotaDto mascotaDto, final Usuario duenio) {

    //Iterando las caracteristicas completas que vienen en el mascotaDto, llenamos una lista:
    List<CaracteristicaCompleta> caracteristicasCompletas = new ArrayList<>();
    List<CaracteristicaCompletaDto> caracteristicasCompletasDtos = mascotaDto.getCaracteristicas();
    for (CaracteristicaCompletaDto caracteristicaCompletaDto : caracteristicasCompletasDtos) {

      //1. Traer caracteristica de base de datos por id
      Caracteristica caracteristicaDeBaseDeDatos =
          caracteristicaRepository.getById(caracteristicaCompletaDto.getIdCaracteristica());

      //2. Insertar respuestas del usuario

      CaracteristicaCompleta caracteristicaCompleta = new CaracteristicaCompleta(
          caracteristicaDeBaseDeDatos.getId(), caracteristicaDeBaseDeDatos, caracteristicaCompletaDto.getRespuesta());

      caracteristicaCompletaRepository.save(caracteristicaCompleta);
      caracteristicasCompletas.add(caracteristicaCompleta);
    }

    //TODO crear fotos???

    //crear la mascota
    Mascota mascota = new Mascota(
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
