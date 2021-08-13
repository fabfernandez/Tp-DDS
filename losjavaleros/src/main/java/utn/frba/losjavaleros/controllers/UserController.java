package utn.frba.losjavaleros.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.frba.losjavaleros.dto.UsuarioDto;
import utn.frba.losjavaleros.model.Usuario;
import utn.frba.losjavaleros.model.exception.InvalidPasswordException;
import utn.frba.losjavaleros.repository.UsuarioRepository;

import java.util.Map;

@RestController
public class UserController {

  final UsuarioRepository usuarioRepository;

  public UserController(final UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  @PostMapping("/validate")
  public String validate(@RequestBody Map<String, String> body) {
    try {
      Usuario user = new Usuario();
      user.setUsername("username");
      user.setPassword("password");
      usuarioRepository.addUser(user);
    } catch (InvalidPasswordException e) {
      return e.getMessage();

    }
    return "ok";

  }

  @PostMapping("/registrarse")
  public ResponseEntity registrate(@RequestBody UsuarioDto usuarioDto) {
    try {
      Usuario user = new Usuario();
      user.setUsername(usuarioDto.getMainContact().getEmail());
      user.setPassword(usuarioDto.getPassword());
      usuarioRepository.addUser(user);
    } catch (InvalidPasswordException e) {
      return ResponseEntity.badRequest().build();

    }
    return ResponseEntity.ok("User registered.");

  }

}
