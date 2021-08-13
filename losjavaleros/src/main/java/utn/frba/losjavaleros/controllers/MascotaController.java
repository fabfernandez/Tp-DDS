package utn.frba.losjavaleros.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import utn.frba.losjavaleros.dto.MascotaDto;
import utn.frba.losjavaleros.model.Usuario;
import utn.frba.losjavaleros.services.MascotaService;

@RestController
public class MascotaController {

  private MascotaService mascotaService;

  public MascotaController(final MascotaService mascotaService) {
    this.mascotaService = mascotaService;
  }

  @PostMapping("/nuevaMascota")
  public ResponseEntity nuevaMascota(@RequestBody MascotaDto mascotaDto) {


    mascotaService.crearMascota(mascotaDto, new Usuario());
    return ResponseEntity.ok("OK");

  }

}
