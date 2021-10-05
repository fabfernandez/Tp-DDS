package utn.frba.losjavaleros.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import utn.frba.losjavaleros.dto.UsuarioDto;
import utn.frba.losjavaleros.model.Usuario;
import utn.frba.losjavaleros.model.exception.InvalidPasswordException;
import utn.frba.losjavaleros.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private Usuario usuario;

    public void crearUsuario(@RequestBody UsuarioDto nuevoUsuario) throws InvalidPasswordException {

            usuario.setDni(nuevoUsuario.getDni());
            usuario.setNombreUsuario(nuevoUsuario.getNombreUsuario());
            usuario.setNombre(nuevoUsuario.getName());
            usuario.setApellido(nuevoUsuario.getApellido());
            usuario.setEmail(nuevoUsuario.getEmail());
            usuario.setContrasenia(nuevoUsuario.getContrasenia());
            usuario.setRoles(nuevoUsuario.getRoles());

            usuarioRepository.save(usuario);
    }
}
