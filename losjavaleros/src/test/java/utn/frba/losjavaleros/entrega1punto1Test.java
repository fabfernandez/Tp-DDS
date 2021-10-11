package utn.frba.losjavaleros;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import utn.frba.losjavaleros.controllers.MascotaController;
import utn.frba.losjavaleros.dto.MascotaDto;
import utn.frba.losjavaleros.model.Mascota;
import utn.frba.losjavaleros.model.Usuario;
import utn.frba.losjavaleros.services.MascotaService;

class entrega1punto1Test {

  private Usuario usuarioSinMascotas;
  private Mascota mascota1;

  @Mock
  private MascotaService mascotaService;

  private MascotaDto mascotaDto;


  @BeforeEach
  void setUp() {
    usuarioSinMascotas = new Usuario(1, 123L, "usuario", "nombre", "apellido", "email",
        "contrasenia", null, new ArrayList<>());

	/*
	 * mascotaDto = new MascotaDto("nombre", "apodo", 5, "perro", "macho",
	 * "descripcion", null, null, "estado");
	 */

    //mascota1 = new Mascota(1, usuarioSinMascotas, null, )

  }

  @Test
  @DisplayName("Se debe permitir el registro de mascotas teniendo en cuenta que una persona puede tener más de una.")
  void consigna() {

  }

  @Test
  @DisplayName("Registrar 1 mascota a un usuario sin mascotas.")
  void registrar1mascota() {
    mascotaService.crearMascota(mascotaDto, usuarioSinMascotas);

  }

  @Test
  @DisplayName("Registrar 2 mascotas a un usuario sin mascotas.")
  void registrar2mascotas() {

  }

  @Test
  @DisplayName("Registrar 2 mascotas a un usuario con mascotas")
  void registrar2mascotasMas() {

  }
}
