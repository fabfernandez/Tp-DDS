package utn.frba.losjavaleros.services;

import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import javassist.NotFoundException;
import utn.frba.losjavaleros.entity.Asociacion;
import utn.frba.losjavaleros.model.Publicacion;
import utn.frba.losjavaleros.model.Rol;
import utn.frba.losjavaleros.model.Usuario;
import utn.frba.losjavaleros.model.Voluntario;
import utn.frba.losjavaleros.repository.AsociacionRepository;
import utn.frba.losjavaleros.repository.PublicacionRepository;
import utn.frba.losjavaleros.repository.RolRepository;
import utn.frba.losjavaleros.repository.UsuarioRepository;
import utn.frba.losjavaleros.repository.VoluntarioRepository;

@Service
public class VoluntarioService {

  private final UsuarioRepository usuarioRepository;

  private final PublicacionRepository publicacionRepository;

  private final VoluntarioRepository voluntarioRepository;

  private final RolRepository rolRepository;

  private final AsociacionRepository asociacionRepository;

  public VoluntarioService(final UsuarioRepository usuarioRepository,
                           final PublicacionRepository publicacionRepository,
                           final VoluntarioRepository voluntarioRepository,
                           final RolRepository rolRepository,
                           final AsociacionRepository asociacionRepository) {
    this.usuarioRepository = usuarioRepository;
    this.publicacionRepository = publicacionRepository;
    this.voluntarioRepository = voluntarioRepository;
    this.rolRepository = rolRepository;
    this.asociacionRepository = asociacionRepository;
  }

  @Transactional
  public Voluntario crearVoluntario(final int usuarioId, final long asociacionId) throws NotFoundException {

    //Si el usuario ya es voluntario no hacer nada

    Usuario usuario = usuarioRepository.findById(usuarioId);

    //si tiene el rol de USUARIO COMUN, entonces:
    //  agregarle el rol de Voluntario.
    var roles = usuario.getRoles();
    if (roles.size() == 1 &&
        roles.stream().anyMatch(rol -> rol.getNombre().equals("usuario"))) {

      Rol rolVoluntario = rolRepository.findById(3L).get();
      Assert.isTrue(Objects.equals(rolVoluntario.getNombre(), "voluntario"),
          "El rol id 3L tiene que ser el voluntario.");

      roles.add(rolVoluntario);
      usuario.setRoles(roles);
      usuarioRepository.save(usuario);
    }

    //agregar Asociacion:
    //  tiene que venir un id para buscar la Asociacion en BD.
    Optional<Asociacion> asociacion = asociacionRepository.findById(asociacionId);
    if (asociacion.isEmpty()) throw new NotFoundException("Id de asociaci??n incorrecto.");
    //crear al Voluntario
    Voluntario voluntario = new Voluntario(usuario, asociacion.get());
    //si el user_id ya existe, lanzar excepcion
    //persistir
    voluntarioRepository.save(voluntario);
    return voluntario;

  }

  @Transactional
  public void aprobarPublicacion(final int idPublicacion) {

    Publicacion publicacion = publicacionRepository.getById(idPublicacion);

    publicacion.aprobar();
    publicacionRepository.save(publicacion);
  }


  @Transactional
  public void rechazarPublicacion(final int idPublicacion) {
    Publicacion publicacion = publicacionRepository.getById(idPublicacion);

    publicacion.rechazar();
    publicacionRepository.save(publicacion);
  }
}
