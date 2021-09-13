package utn.frba.losjavaleros.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utn.frba.losjavaleros.dto.HogarTransitoDto;
import utn.frba.losjavaleros.services.HogaresDeTransitoService;

import java.util.ArrayList;

@RestController
public class HogaresDeTransitoController {

    private HogaresDeTransitoService hogaresDeTransitoService;

    public HogaresDeTransitoController(HogaresDeTransitoService hogaresDeTransitoService) {
        this.hogaresDeTransitoService = hogaresDeTransitoService;
    }

    //PUNTO 2.4
    //La API de hogares de transito permite buscar con filtros.
    @GetMapping("/buscarHogares")
    public ResponseEntity buscarHogares(@RequestParam final String tipoMascota,
                                        @RequestParam final boolean patio,
                                        @RequestParam final double x,
                                        @RequestParam final double y,
                                        @RequestParam final double radioDeCercania) {

        ArrayList<HogarTransitoDto> resultado =
                hogaresDeTransitoService.buscarHogares(tipoMascota, patio, x, y, radioDeCercania);

        return new ResponseEntity(resultado, HttpStatus.OK);

    }

}
