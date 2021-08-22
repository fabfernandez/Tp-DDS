package utn.frba.losjavaleros.services;

import org.springframework.stereotype.Service;
import utn.frba.losjavaleros.model.Usuario;
import utn.frba.losjavaleros.model.Voluntario;
import utn.frba.losjavaleros.repository.UsuarioRepository;

@Service
public class VoluntarioService {

  private UsuarioRepository usuarioRepository;

  public VoluntarioService(final UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }


  public Voluntario crearVoluntario(final int usuarioId) {
    Usuario usuario = usuarioRepository.findById(usuarioId);
    return new Voluntario(usuario);
  }
}
