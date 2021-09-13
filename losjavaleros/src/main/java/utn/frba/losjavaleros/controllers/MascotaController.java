package utn.frba.losjavaleros.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.frba.losjavaleros.dto.FormMascotaConChapitaDto;
import utn.frba.losjavaleros.dto.MascotaDto;
import utn.frba.losjavaleros.model.Usuario;
import utn.frba.losjavaleros.services.MascotaService;

@RestController
@RequestMapping("mascotas")
public class MascotaController {

  private MascotaService mascotaService;

  public MascotaController(final MascotaService mascotaService) {
    this.mascotaService = mascotaService;
  }

  @PostMapping()
  public ResponseEntity nuevaMascota(@RequestBody MascotaDto mascotaDto) {
    mascotaService.crearMascota(mascotaDto, new Usuario());
    return new ResponseEntity(mascotaService.crearMascota(mascotaDto, new Usuario()), HttpStatus.OK);
  }

  @GetMapping("/{estado}")
  public ResponseEntity listarMascotas(@PathVariable String estado) {
    return new ResponseEntity(mascotaService.filtrarMascotas(estado), HttpStatus.OK);

  }


  //PUNTO 2.1

  //El link grabado en el QR de la chapita lleva a un front-end que hace primero el siguiente request,
  //para ver si existe la mascota con ese ID. Si esta respuesta devuelve 200 es porque la mascota existe.
  @GetMapping("/{id}")
  public ResponseEntity getMascota(@PathVariable int id) {
    mascotaService.getMascotaById(id);
    return new ResponseEntity(HttpStatus.OK);

  }
  //Si la mascota existe el front-end, le ofrece al usuario un formulario,
  // el usuario llena el formulario y se envia con este endpoint.
  @PostMapping("/encontrada/{mascotaId}")
  public ResponseEntity mascotaEncontradaConChapita(@RequestBody FormMascotaConChapitaDto formulario,
                                                    @PathVariable int mascotaId) {
    mascotaService.notificarSobreMascotaEncontrada(formulario, mascotaId);
    return new ResponseEntity(HttpStatus.OK);

  }

}
