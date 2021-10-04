package utn.frba.losjavaleros.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.frba.losjavaleros.dto.UsuarioDto;
import utn.frba.losjavaleros.model.Usuario;
import utn.frba.losjavaleros.model.exception.InvalidPasswordException;
import utn.frba.losjavaleros.repository.UsuarioRepository;
import utn.frba.losjavaleros.services.UsuarioService;

import java.util.Map;

@RestController
public class UsuarioController {

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
    try {
      usuarioService.crearUsuario(usuarioDto);
    } catch (InvalidPasswordException e) {
      return ResponseEntity.badRequest().build();

    }
    return ResponseEntity.ok("Usuario registrado.");

  }

}
