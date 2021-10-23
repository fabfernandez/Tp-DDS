package utn.frba.losjavaleros.services;

import org.springframework.stereotype.Service;
import utn.frba.losjavaleros.entity.Asociacion;
import utn.frba.losjavaleros.model.Publicacion;
import utn.frba.losjavaleros.model.Usuario;
import utn.frba.losjavaleros.model.Voluntario;
import utn.frba.losjavaleros.repository.PublicacionRepository;
import utn.frba.losjavaleros.repository.UsuarioRepository;
import utn.frba.losjavaleros.repository.VoluntarioRepository;

@Service
public class VoluntarioService {

    private final UsuarioRepository usuarioRepository;

    private final PublicacionRepository publicacionRepository;

    private final VoluntarioRepository voluntarioRepository;

    public VoluntarioService(final UsuarioRepository usuarioRepository,
                             final PublicacionRepository publicacionRepository,
                             final VoluntarioRepository voluntarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.publicacionRepository = publicacionRepository;
        this.voluntarioRepository = voluntarioRepository;
    }


    public Voluntario crearVoluntario(final int usuarioId) {

        Usuario usuario = usuarioRepository.findById(usuarioId);

        //si tiene el rol de USUARIO COMUN, entonces:
        //  cambiar el rol a VOLUNTARIO

        //agregar Asociacion:
        //  tiene que venir un id para buscar la Asociacion en BD.
        Asociacion asociacion = new Asociacion();

        //crear al Voluntario
        Voluntario voluntario = new Voluntario(usuario, asociacion);
        //persistir
        voluntarioRepository.save(voluntario);
        return null;

    }

    public void aprobarPublicacion(final int idPublicacion) {

        Publicacion publicacion = publicacionRepository.getById(idPublicacion);

        publicacion.aprobar();
    }

    public void rechazarPublicacion(final int idPublicacion) {
        Publicacion publicacion = publicacionRepository.getById(idPublicacion);

        publicacion.rechazar();
    }
}
