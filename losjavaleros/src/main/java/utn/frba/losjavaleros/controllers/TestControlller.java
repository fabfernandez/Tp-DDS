package utn.frba.losjavaleros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utn.frba.losjavaleros.model.User;
import utn.frba.losjavaleros.model.exception.InvalidPasswordException;
import utn.frba.losjavaleros.repository.UserRepository;

import java.util.Map;

@RestController
public class TestControlller {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }

    @PostMapping("/validate")
    public String validate(@RequestBody Map<String,String> body)  {
        try{
            User user = new User();
            user.setUsername("username");
            user.setPassword("password");
            userRepository.addUser(user);
        }catch (InvalidPasswordException e){
            return e.getMessage();
        }

        return "ok";
    }
}
