package utn.frba.losjavaleros;

import lombok.extern.java.Log;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import utn.frba.losjavaleros.entity.Asociacion;
import utn.frba.losjavaleros.model.Rol;
import utn.frba.losjavaleros.model.Usuario;
import utn.frba.losjavaleros.repository.AsociacionRepository;
import utn.frba.losjavaleros.repository.RolRepository;
import utn.frba.losjavaleros.repository.UsuarioRepository;

import java.util.Collections;

@Log
@Component
public class AppRunner implements ApplicationRunner {

  UsuarioRepository usuarioRepository;

  RolRepository rolRepository;

  AsociacionRepository asociacionRepository;

  public AppRunner(final UsuarioRepository usuarioRepository, final RolRepository rolRepository,
                   final AsociacionRepository asociacionRepository) {
    this.usuarioRepository = usuarioRepository;
    this.rolRepository = rolRepository;
    this.asociacionRepository = asociacionRepository;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    try {
      if (usuarioRepository.findByNombreUsuario("admin") == null) {
        Usuario usuario = new Usuario(
            1L,
            "admin",
            "mario",
            "bros",
            "mariobros@mail.com",
            "Test1234.",
            Collections.singletonList(new Rol(1L, "ADMIN")));
        usuarioRepository.save(usuario);
        log.info("Usuario ADMIN creado.");
      }

      Rol rolUsuario = new Rol(2L, "usuario");
      rolRepository.save(rolUsuario);
      Rol rolVoluntario = new Rol(3L, "voluntario");
      rolRepository.save(rolVoluntario);
      log.info("Roles creados.");

      Asociacion asociacion1 = new Asociacion(1L, "Salvemos a los gatitos");
      asociacionRepository.save(asociacion1);
      log.info("Asociación 'Salvemos a los gatitos' creada.");

    } catch (Exception e) {
      log.warning("No se ejecutaron todos los inserts iniciales.");
    }
  }
}
