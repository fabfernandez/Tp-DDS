package utn.frba.losjavaleros.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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


        //Traer caracteristicas de base de datos por id
        Caracteristica caracteristicaDeBaseDeDatos = new Caracteristica("Color principal", "input");

        //insertar respuestas del usuario
        List<CaracteristicaCompleta> caracteristicas =
                List.of(new CaracteristicaCompleta(caracteristicaDeBaseDeDatos, "Rosa"));

        //TODO crear fotos???

        //crear la mascota
        Mascota mascota = new Mascota(
                1, //TODO ESTE VALOR DEBE SER AUTO INCREMENTAL.
                duenio,
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
        duenio.getMascotas().add(mascota);

        return mascota;
    }

    public List<Mascota> filtrarMascotas(String estado) {
        return mascotaRepository.getMascotasEstado(estado);
    }

    public void notificarSobreMascotaEncontrada(final FormMascotaConChapitaDto formulario, final int mascotaId) {
        /*
         * Una vez completado el formulario, el sistema deberá notificarle de esta situación al dueño
         * (conocido por estar ligado a la chapita) mediante los medios de notificación preferidos.*/
        Mascota mascota = mascotaRepository.getMascotaById(mascotaId);
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
        return mascotaRepository.getMascotaById(id);
    }

}
