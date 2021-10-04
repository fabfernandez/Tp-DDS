package utn.frba.losjavaleros.securityContext;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController {
	
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
    @ResponseBody
    public String usuarioActual(Principal principal) {
        return principal.getName();
    }

}
