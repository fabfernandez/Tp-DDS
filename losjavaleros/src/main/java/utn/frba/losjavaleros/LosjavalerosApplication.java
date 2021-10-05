package utn.frba.losjavaleros;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
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
public class LosjavalerosApplication  {



    public static void main(String[] args) {
        SpringApplication.run(LosjavalerosApplication.class, args);
    }

}
