package utn.frba.losjavaleros.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
  
  
  
  //link grabado en el QR de la CHAPITA
  @GetMapping("/{id}")
  public ResponseEntity getMascota(@PathVariable String id) {
	  Mascota mascota =mascotaService.getMascotaById(id);
  return new ResponseEntity(mascota, HttpStatus.OK);

  }

  @PostMapping("/mascotaEncontrada/{mascotaId}")
  public ResponseEntity mascotaEncontradaConChapita(@RequestBody String formulario, @PathVariable int mascotaId) {
    return new ResponseEntity(mascotaService.mascotaEncontradaConChapita(formulario, mascotaId), HttpStatus.OK);

  }
  
  
 

}
