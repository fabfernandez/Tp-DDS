package utn.frba.losjavaleros.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import utn.frba.losjavaleros.dto.FormMascotaConChapitaDto;
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
                1, //TODO ESTE VALOR DEBE SER AUTO INCREMENTAL.
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

    public List<Mascota> filtrarMascotas(String estado) {
        return mascotaRepository.getMascotasEstado(estado);
    }

    public void notificarSobreMascotaEncontrada(final FormMascotaConChapitaDto formulario, final int mascotaId) {
        /*
         * Una vez completado el formulario, el sistema deberá notificarle de esta situación al dueño
         * (conocido por estar ligado a la chapita) mediante los medios de notificación preferidos.*/
        Mascota mascota = mascotaRepository.getMascotaById(mascotaId);

        //TODO notificar al dueño
    }

    public Mascota getMascotaById(int id) {
        return mascotaRepository.getMascotaById(id);
    }

}
