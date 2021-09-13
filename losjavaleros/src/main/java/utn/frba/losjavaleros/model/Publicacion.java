package utn.frba.losjavaleros.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Publicacion {

	private Integer id;
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

	public void aprobar() {
		this.estadoPublicacion = EstadoPublicacion.APROBADA;
	}

	public void rechazar() {
		this.estadoPublicacion = EstadoPublicacion.RECHAZADA;
	}
}
