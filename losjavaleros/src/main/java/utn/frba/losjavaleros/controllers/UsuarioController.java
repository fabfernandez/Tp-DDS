package utn.frba.losjavaleros.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import utn.frba.losjavaleros.dto.UsuarioDto;
import utn.frba.losjavaleros.model.Rol;
import utn.frba.losjavaleros.model.Usuario;
import utn.frba.losjavaleros.model.exception.InvalidPasswordException;
import utn.frba.losjavaleros.repository.UsuarioRepository;
import utn.frba.losjavaleros.services.UsuarioService;

import java.security.Principal;
import java.util.Collection;
import java.util.Map;


@Slf4j
@Transactional
@RestController
@RequestMapping("/api")
public class UsuarioController {

//	private final Logger log = LoggerFactory.getLogger(EditorialResource.class);

	private final UsuarioRepository usuarioRepository;
	private final UsuarioService usuarioService;

	public UsuarioController(final UsuarioRepository usuarioRepository, final UsuarioService usuarioService) {
		this.usuarioRepository = usuarioRepository;
		this.usuarioService = usuarioService;
	}

	@PostMapping("/validar")
	public String validar(@RequestBody Map<String, String> body) {
		try {
			Usuario user = new Usuario();
			user.setNombreUsuario("usuario");
			user.setContrasenia("password");
			usuarioRepository.save(user);
		} catch (InvalidPasswordException e) {
			return e.getMessage();

		}
		return "ok";

	}

	//PUNTO 1.5
	@PostMapping("/registrarse")
	public ResponseEntity registrate(@RequestBody UsuarioDto usuarioDto) {
		
		log.debug("REST request to save UsuarioDto : {}", usuarioDto);
		
		try {
			usuarioService.crearUsuario(usuarioDto);
		} catch (InvalidPasswordException e) {
			return ResponseEntity.badRequest().build();

		}
		return ResponseEntity.ok("Usuario registrado.");

	}

	@GetMapping( "/email")
	@ResponseBody
	public String currentUserName(Principal principal) {
		return principal.getName();

	}

	@GetMapping( "/rol")
	@ResponseBody
	public Collection<Rol> getRol(Principal principal) {
		String nombreUsuario = principal.getName();
		Usuario usuario = usuarioRepository.findByEmail(nombreUsuario);
		return usuario.getRoles();

	}

}
