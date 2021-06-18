package utn.frba.losjavaleros.model.exception;

import org.passay.RuleResultDetail;

import java.util.List;

public class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String errorMessage) {
        super(errorMessage);
    }
}
