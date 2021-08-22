package utn.frba.losjavaleros.model;

import java.time.LocalDate;
import java.util.List;

public class Publicacion {
	
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private Integer dni;
	private String direccion;
	private Contacto contacto;

	private List<Foto> fotos;
	private String descripcion;
	private Double coordenadasX;
	private Double coordenadasY;
	
	private EstadoPublicacion estadoPublicacion;
	
	
	
	
}
