package utn.frba.losjavaleros.services;

import org.springframework.stereotype.Service;
import utn.frba.losjavaleros.entity.Asociacion;
import utn.frba.losjavaleros.model.Publicacion;
import utn.frba.losjavaleros.model.Usuario;
import utn.frba.losjavaleros.model.Voluntario;
import utn.frba.losjavaleros.repository.PublicacionRepository;
import utn.frba.losjavaleros.repository.UsuarioRepository;

@Service
public class VoluntarioService {

    private UsuarioRepository usuarioRepository;

    private PublicacionRepository publicacionRepository;

    public VoluntarioService(final UsuarioRepository usuarioRepository,
                             final PublicacionRepository publicacionRepository) {
        this.usuarioRepository = usuarioRepository;
        this.publicacionRepository = publicacionRepository;
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

        return null;

    }

    public void aprobarPublicacion(int idPublicacion) {

        Publicacion publicacion = publicacionRepository.getById(idPublicacion);

        publicacion.aprobar();
    }

    public void rechazarPublicacion(int idPublicacion) {
        Publicacion publicacion = publicacionRepository.getById(idPublicacion);

        publicacion.rechazar();
    }
}
