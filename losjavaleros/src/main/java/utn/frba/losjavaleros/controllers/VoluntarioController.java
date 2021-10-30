package utn.frba.losjavaleros.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javassist.NotFoundException;
import utn.frba.losjavaleros.model.Voluntario;
import utn.frba.losjavaleros.services.VoluntarioService;

@RestController
public class VoluntarioController {

    private VoluntarioService voluntarioService;

    public VoluntarioController(final VoluntarioService voluntarioService) {
        this.voluntarioService = voluntarioService;
    }

    //PUNTO 2.3
    @PostMapping("/serVoluntario/{usuarioId}/asociacion/{asociacionId}")
    public ResponseEntity serVoluntario(@PathVariable final int usuarioId, @PathVariable final long asociacionId) throws NotFoundException {

        //No puede pasarse el usario ID por parametro, no tiene seguridad.
        //TODO Obtener el ID del usuario logeado.

        //si el usuario loggeado ya es voluntario, lanzar excepcion.

        Voluntario voluntario = voluntarioService.crearVoluntario(usuarioId, asociacionId);

        return new ResponseEntity(voluntario, HttpStatus.OK);
        //TODO en version productiva, no devolver al voluntario.

    }
    //PUNTO 2.3
    @PostMapping("/aprobarPublicacion/{idPublicacion}")
    public ResponseEntity aprobarPublicacion(@PathVariable final int idPublicacion) {

        //probar que el usuario loggeado es un voluntario.

        voluntarioService.aprobarPublicacion(idPublicacion);

        return new ResponseEntity(HttpStatus.OK);

    }
    //PUNTO 2.3
    @PostMapping("/rechazarPublicacion/{idPublicacion}")
    public ResponseEntity rechazarPublicacion(@PathVariable final int idPublicacion) {

        voluntarioService.rechazarPublicacion(idPublicacion);

        return new ResponseEntity(HttpStatus.OK);

    }

}
