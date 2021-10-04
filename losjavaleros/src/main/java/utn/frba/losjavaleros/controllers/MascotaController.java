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

  //PUNTO 1.1
  @PostMapping()
  public ResponseEntity nuevaMascota(@RequestBody MascotaDto mascotaDto) {
    //TODO capturar el usuario actual
    mascotaService.crearMascota(mascotaDto, new Usuario());
    return new ResponseEntity(mascotaService.crearMascota(mascotaDto, new Usuario()), HttpStatus.OK);
  }

  @GetMapping("/{estado}")
  public ResponseEntity listarMascotas(@PathVariable String estado) {
    return new ResponseEntity(mascotaService.filtrarMascotas(estado), HttpStatus.OK);

  }

  //PUNTO 2.1
  //El QR de la chapita tiene un link a un formulario
  //Si la mascota existe, el usuario llena el formulario y se envía con este endpoint.
  @PostMapping("/encontrada/{mascotaId}")
  public ResponseEntity mascotaEncontradaConChapita(@RequestBody FormMascotaConChapitaDto formulario,
                                                    @PathVariable int mascotaId) {
    mascotaService.getMascotaById(mascotaId); //chequeo de que la mascota existe
    mascotaService.notificarSobreMascotaEncontrada(formulario, mascotaId);
    return new ResponseEntity(HttpStatus.OK);

  }

}
