package utn.frba.losjavaleros.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.passay.RuleResult;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import utn.frba.losjavaleros.model.exception.InvalidPasswordException;
import utn.frba.losjavaleros.security.PasswordValidatorSingleton;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor

public class Usuario {

    private Long dni;
    private String usuario;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasenia;

    private Collection<Rol> roles;

    //no borrar este constructor!
    public Usuario(Long dni, String firstName, String lastName, String email, String contrasenia, Collection<Rol> roles)
        throws InvalidPasswordException {
        this.dni = dni;
        this.nombre = firstName;
        this.apellido = lastName;
        this.email = email;
        this.roles = roles;
        setContrasenia(contrasenia);
    }

    public void setContrasenia(String contrasenia) throws InvalidPasswordException {

        RuleResult validate = PasswordValidatorSingleton.getInstance().validate(this.usuario, contrasenia);
        if(validate.isValid()) {
            contrasenia = new BCryptPasswordEncoder().encode(contrasenia);
            this.contrasenia = contrasenia;
        }else
            throw new InvalidPasswordException(validate.getDetails().toString());
    }
}