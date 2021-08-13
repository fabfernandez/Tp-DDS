package utn.frba.losjavaleros.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import utn.frba.losjavaleros.dto.MascotaDto;
import utn.frba.losjavaleros.repository.UsuarioRepository;
import utn.frba.losjavaleros.services.MascotaService;

@RestController
public class MascotaController {

  private MascotaService mascotaService;
  private MascotaService mascotaService;

  public MascotaController(final MascotaService mascotaService) {
    this.mascotaService = mascotaService;
  }

  @PostMapping("/nuevaMascota")
  public ResponseEntity nuevaMascota(@RequestBody MascotaDto mascotaDto) {

    UsuarioRepository usuarioRepository

    mascotaService.crearMascota(mascotaDto, usuario);
    return ResponseEntity.ok("OK");

  }

}
