package utn.frba.losjavaleros.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import javassist.NotFoundException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import utn.frba.losjavaleros.entity.Asociacion;
import utn.frba.losjavaleros.model.Rol;
import utn.frba.losjavaleros.model.Usuario;
import utn.frba.losjavaleros.model.Voluntario;
import utn.frba.losjavaleros.repository.AsociacionRepository;
import utn.frba.losjavaleros.repository.PublicacionRepository;
import utn.frba.losjavaleros.repository.RolRepository;
import utn.frba.losjavaleros.repository.UsuarioRepository;
import utn.frba.losjavaleros.repository.VoluntarioRepository;
import utn.frba.losjavaleros.services.VoluntarioService;

@ExtendWith(MockitoExtension.class)
class VoluntarioControllerIntegrationTest {

  private VoluntarioController voluntarioController;
  private VoluntarioService voluntarioService;

  private UsuarioRepository usuarioRepository;
  private VoluntarioRepository voluntarioRepository;
  private PublicacionRepository publicacionRepository;
  private RolRepository rolRepository;
  private AsociacionRepository asociacionRepository;
  private Usuario usuario;
  private Rol rol;
  private Collection<Rol> roles;


  @BeforeEach
  void setUp(){
    usuarioRepository = mock(UsuarioRepository.class);
    voluntarioRepository = mock(VoluntarioRepository.class);
    publicacionRepository = mock(PublicacionRepository.class);
    rolRepository = mock(RolRepository.class);
    asociacionRepository = mock(AsociacionRepository.class);
    usuario = mock(Usuario.class);
    voluntarioService = new VoluntarioService(usuarioRepository, publicacionRepository, voluntarioRepository,
        rolRepository, asociacionRepository);
    voluntarioController = new VoluntarioController(voluntarioService);

    rol = new Rol(2L, "usuario");
    roles = new ArrayList<>();
    roles.add(rol);
  }

  @Test
  void serVoluntario() throws NotFoundException {
    when(rolRepository.findById(3L)).thenReturn(Optional.of(new Rol(3L, "voluntario")));
    when(usuario.getRoles()).thenReturn(roles);
    when(usuarioRepository.findById(2)).thenReturn(usuario);
    when(asociacionRepository.findById(1L)).thenReturn(Optional.of(mock(Asociacion.class)));

    ResponseEntity<Voluntario> responseEntity = voluntarioController.serVoluntario(2, 1);
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
  }

}