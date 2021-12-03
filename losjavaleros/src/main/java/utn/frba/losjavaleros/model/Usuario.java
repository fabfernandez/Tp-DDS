package utn.frba.losjavaleros.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.passay.RuleResult;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import utn.frba.losjavaleros.model.exception.InvalidPasswordException;
import utn.frba.losjavaleros.security.PasswordValidatorSingleton;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Long dni;
  private String nombreUsuario;
  private String nombre;
  private String apellido;
  private LocalDate fechaNacimiento;
  private String direccion;
  private String email;
  private String contrasenia;
  @OneToOne
  private Contacto contactoPrincipal;
  @OneToMany
  private List<Contacto> contactosAdicionales;
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Collection<Rol> roles;
  @OneToMany(cascade = CascadeType.ALL)
  private List<Mascota> mascotas;

/*
  public Usuario(final Integer id, final Long dni, final String nombreUsuario, final String nombre,
                 final String apellido, final LocalDate fechaNacimiento, final String direccion,
                 final String email, final String contrasenia, final Collection<Rol> roles,
                 final List<Mascota> mascotas) {
    this.id = id;
    this.dni = dni;
    this.nombreUsuario = nombreUsuario;
    this.nombre = nombre;
    this.apellido = apellido;
    this.fechaNacimiento = fechaNacimiento;
    this.direccion = direccion;
    this.email = email;
    this.contrasenia = contrasenia;
    this.roles = roles;
    this.mascotas = mascotas;
  }

 */

  //no borrar este constructor!
  public Usuario(Long dni, String nombreUsuario, String nombre, String apellido, String email, String contrasenia,
                 Collection<Rol> roles)
      throws InvalidPasswordException {
    this.dni = dni;
    this.nombreUsuario = nombreUsuario;
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.roles = roles;
    setContrasenia(contrasenia);
  }

  public void setContrasenia(String contrasenia) throws InvalidPasswordException {

    RuleResult validate = PasswordValidatorSingleton.getInstance().validate(this.nombreUsuario, contrasenia);
    if (validate.isValid()) {
      contrasenia = new BCryptPasswordEncoder().encode(contrasenia);
      this.contrasenia = contrasenia;
    } else
      throw new InvalidPasswordException(validate.getDetails().toString());
  }
}