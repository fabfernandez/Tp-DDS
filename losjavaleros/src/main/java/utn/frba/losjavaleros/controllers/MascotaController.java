package utn.frba.losjavaleros.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.frba.losjavaleros.dto.MascotaDto;
import utn.frba.losjavaleros.model.Usuario;
import utn.frba.losjavaleros.services.MascotaService;

import javax.websocket.server.PathParam;

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
    return ResponseEntity.ok("OK");

  }
  @GetMapping("/{estado}")
  public ResponseEntity listarMascotas(@PathVariable String estado){
    return new ResponseEntity(mascotaService.filtrarMascotas(estado), HttpStatus.OK);

  }
}