package utn.frba.losjavaleros.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.frba.losjavaleros.dto.FormMascotaConChapitaDto;
import utn.frba.losjavaleros.dto.MascotaDto;
import utn.frba.losjavaleros.model.Mascota;
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


  //Link grabado en el QR de la CHAPITA, el usuario abre este link y el front-end recibe el ID si encuentra a la
  // mascota correspondiente.
  @GetMapping("/{id}")
  public ResponseEntity getMascota(@PathVariable int id) {
    int mascotaId = mascotaService.getMascotaById(id);
    return new ResponseEntity(mascotaId, HttpStatus.OK);

  }

  //Si el ID de la mascota es correcto al hacer /mascotas/ID, el usuario llena el formulario y lo envia con este
  // endpoint.
  @PostMapping("/encontrada/{mascotaId}")
  public ResponseEntity mascotaEncontradaConChapita(@RequestBody FormMascotaConChapitaDto formulario,
                                                    @PathVariable int mascotaId) {
    return new ResponseEntity(mascotaService.mascotaEncontradaConChapita(formulario, mascotaId), HttpStatus.OK);

  }

}
