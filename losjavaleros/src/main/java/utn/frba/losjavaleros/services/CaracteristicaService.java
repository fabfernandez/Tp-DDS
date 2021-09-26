package utn.frba.losjavaleros.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import utn.frba.losjavaleros.dto.CaracteristicaDto;
import utn.frba.losjavaleros.model.Caracteristica;
import utn.frba.losjavaleros.repository.CaracteristicaRepository;

@Service
public class CaracteristicaService {

    @Autowired
    private CaracteristicaRepository caracteristicaRepository;
    private Caracteristica caracteristica;

    public void agregarCaracteristica(@RequestBody CaracteristicaDto nuevaCaracteristica) {

        caracteristica.setNombre(nuevaCaracteristica.getNombre());
        caracteristica.setTipo(nuevaCaracteristica.getTipo());

        caracteristicaRepository.agregarCaracteristica(caracteristica);
    }

}
