package utn.frba.losjavaleros.services;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import javassist.NotFoundException;
import static org.junit.jupiter.api.Assertions.*;
import utn.frba.losjavaleros.model.Usuario;
import utn.frba.losjavaleros.model.Voluntario;
import utn.frba.losjavaleros.model.exception.InvalidPasswordException;
import utn.frba.losjavaleros.repository.UsuarioRepository;

class VoluntarioServiceTest {

  private VoluntarioService voluntarioService;

  @Mock
  private UsuarioRepository usuarioRepository;

  @BeforeEach
  void setUp() throws InvalidPasswordException {
    Usuario usuario = new Usuario(123L, "faba", "faba", "faba", "email@gmail.com", "ohyes", new ArrayList<>());
    Mockito.when(usuarioRepository.findById(Mockito.anyInt())).thenReturn(usuario);

  }

  @Test
  @DisplayName("Nuevo Voluntario.")
  void crearVoluntario() throws NotFoundException {
    //Con el ID del usuario identificado, crear un nuevo Voluntario.
    // Se basa al Voluntario en el Usuario recibido.
    // Se busca en BD al usuario para traer todos los datos disponibles.

    //pasos del service:
    //  traer id del usuario loggeado
    //  consultar repositorio usuarios
    //  instanciar Voluntario
    //  persistirlo

    Voluntario voluntario = voluntarioService.crearVoluntario(123, 1L);
    //probar que el Voluntario esté persistido.

  }

  @Test
  void aprobarPublicacion() {
  }

  @Test
  void rechazarPublicacion() {
  }
}