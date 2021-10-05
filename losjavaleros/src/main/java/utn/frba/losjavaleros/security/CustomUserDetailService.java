package utn.frba.losjavaleros.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import utn.frba.losjavaleros.model.Usuario;
import utn.frba.losjavaleros.repository.UsuarioRepository;
import utn.frba.losjavaleros.services.UsuarioService;

import javax.annotation.PostConstruct;

@Service
public class CustomUserDetailService implements UserDetailsService {

  @Autowired
  private WebApplicationContext applicationContext;

  private UsuarioRepository usuarioRepository;


  @PostConstruct
  public void completeSetup() {
      usuarioRepository = applicationContext.getBean(UsuarioRepository.class);
  }

    @Override
    public UserDetails loadUserByUsername(final String username) {
        final Usuario appUser = usuarioRepository.findByNombreUsuario(username);
        if (appUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UsuarioPrincipal(appUser);
    }
}