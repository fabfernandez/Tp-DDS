package utn.frba.losjavaleros.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.frba.losjavaleros.dto.LoginDto;
import utn.frba.losjavaleros.dto.UserDto;
import utn.frba.losjavaleros.model.User;
import utn.frba.losjavaleros.model.exception.InvalidPasswordException;
import utn.frba.losjavaleros.repository.UserRepository;

import java.util.Map;

@RestController
public class UserController {

  final UserRepository userRepository;

  public UserController(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping("/validate")
  public String validate(@RequestBody Map<String, String> body) {
    try {
      User user = new User();
      user.setUsername("username");
      user.setPassword("password");
      userRepository.addUser(user);
    } catch (InvalidPasswordException e) {
      return e.getMessage();

    }
    return "ok";

  }

  @PostMapping("/registrate")
  public ResponseEntity registrate(@RequestBody UserDto userDto) {
    try {
      User user = new User();
      user.setUsername(userDto.getMainContact().getEmail());
      user.setPassword(userDto.getPassword());
      userRepository.addUser(user);
    } catch (InvalidPasswordException e) {
      return ResponseEntity.notFound().build();

    }
    return ResponseEntity.ok("User registered.");

  }

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
    return ResponseEntity.ok("Log in successful.");

  }
}
