package utn.frba.losjavaleros;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import utn.frba.losjavaleros.model.Rol;
import utn.frba.losjavaleros.model.Usuario;
import utn.frba.losjavaleros.repository.UsuarioRepository;

import java.util.Collections;
@Log
@Component
public class AppRunner implements ApplicationRunner {


    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("EXECUTING : command line runner");
        try {

            Usuario usuario = new Usuario(
                    1L,
                    "admin",
                    "mario",
                    "bros",
                    "mariobros@mail.com",
                    "Test1234.",Collections.singletonList(
                            new Rol(1L,"ADMIN")));
            usuarioRepository.save(usuario);
        } catch (Exception e) {
            log.info("not saved user");
        }
    }
}
