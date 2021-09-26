package utn.frba.losjavaleros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import utn.frba.losjavaleros.dto.CaracteristicaDto;
import utn.frba.losjavaleros.services.CaracteristicaService;

@RestController
public class CaracteristicaController {

    @Autowired
    private CaracteristicaService caracteristicaService;

    @PostMapping("/agregar")
    public ResponseEntity agregarCatacteristica(@RequestBody CaracteristicaDto nuevaCaracteristica) throws Exception {
        try{
            caracteristicaService.agregarCaracteristica(nuevaCaracteristica);
        } catch(Exception e) {
            throw new Exception(e);
        }

        return ResponseEntity.ok("Caracteristica agregada");

    }
}
