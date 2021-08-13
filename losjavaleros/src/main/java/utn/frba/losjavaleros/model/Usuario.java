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
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private Collection<Role> roles;

    //no borrar este constructor!
    public Usuario(Long dni, String firstName, String lastName, String email, String password, Collection<Role> roles)
        throws InvalidPasswordException {
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
        setPassword(password);
    }

    public void setPassword(String password) throws InvalidPasswordException {

        RuleResult validate = PasswordValidatorSingleton.getInstance().validate(this.username, password);
        if(validate.isValid()) {
            password = new BCryptPasswordEncoder().encode(password);
            this.password = password;
        }else
            throw new InvalidPasswordException(validate.getDetails().toString());
    }
}