package utn.frba.losjavaleros.services;

import org.springframework.stereotype.Service;
import utn.frba.losjavaleros.dto.HogarTransitoDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class HogaresDeTransitoService {


    public ArrayList<HogarTransitoDto> buscarHogares(String tipoMascota,
                                                     boolean patio,
                                                     double x,
                                                     double y,
                                                     double radioDeCercania) {

        //Acá se deberia llamar a la API de hogares de transito pasandole todos los parametros para hacer una busqueda.
        //Como la API no existe, devolvemos una lista cualquiera de hogares.

        HogarTransitoDto hogar1 = new HogarTransitoDto("Hogar felices las mascotas", "Calle falsa 123");
        HogarTransitoDto hogar2 = new HogarTransitoDto("Hogar Random", "Calle random 2222");
        HogarTransitoDto hogar3 = new HogarTransitoDto("Hogar Mascotita Perdida", "Calle principal 2600");

        return new ArrayList<HogarTransitoDto>(List.of(hogar1, hogar2, hogar3));

    }
}
