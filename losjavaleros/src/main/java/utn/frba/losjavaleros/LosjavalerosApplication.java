package utn.frba.losjavaleros;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utn.frba.losjavaleros.model.Mascota;
import utn.frba.losjavaleros.model.Rol;
import utn.frba.losjavaleros.model.Usuario;
import utn.frba.losjavaleros.repository.UsuarioRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
@Log
public class LosjavalerosApplication implements CommandLineRunner {

    @Autowired
    UsuarioRepository usuarioRepository;


    public static void main(String[] args) {
        SpringApplication.run(LosjavalerosApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("EXECUTING : command line runner");
        Usuario usuario  = new Usuario(1,
                1L,
                "admin",
                "mario",
                "bros",
                "mariobros@mail.com",
                "itsmeMar10", Collections.EMPTY_LIST, Collections.EMPTY_LIST);
        usuarioRepository.save(usuario);
    }
}
