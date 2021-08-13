package utn.frba.losjavaleros.securityContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GetUserWithCustomInterfaceController {
	
	 @Autowired
	    private IAuthenticationFacade authenticationFacade;

	    @RequestMapping(value = "/username", method = RequestMethod.GET)
	    @ResponseBody
	    public String currentUserNameSimple() {
	        Authentication authentication = authenticationFacade.getAuthentication();
	        return authentication.getName();
	    }

}
