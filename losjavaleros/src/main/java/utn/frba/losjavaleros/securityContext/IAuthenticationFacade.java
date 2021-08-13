package utn.frba.losjavaleros.securityContext;

import org.springframework.security.core.Authentication;

public interface IAuthenticationFacade {
	 Authentication getAuthentication();

}
