package utn.frba.losjavaleros.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import utn.frba.losjavaleros.model.Voluntario;
import utn.frba.losjavaleros.services.VoluntarioService;

@RestController
public class VoluntarioController {

  private VoluntarioService voluntarioService;

  public VoluntarioController(final VoluntarioService voluntarioService) {
    this.voluntarioService = voluntarioService;
  }

  @PostMapping("/serVoluntario/{usuarioId}")
  public ResponseEntity serVoluntario(@PathVariable final int usuarioId) {

    Voluntario voluntario = voluntarioService.crearVoluntario(usuarioId);

    return new ResponseEntity(voluntario, HttpStatus.OK);

  }

}
