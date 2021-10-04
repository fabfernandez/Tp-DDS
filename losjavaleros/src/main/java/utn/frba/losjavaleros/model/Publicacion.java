package utn.frba.losjavaleros.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
public class Publicacion {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nombre;
  private String apellido;
  private LocalDate fechaNacimiento;
  private Integer dni;
  private String direccion;
  @OneToOne
  private Contacto contacto;
  @OneToMany
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
