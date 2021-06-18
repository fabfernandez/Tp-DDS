package utn.frba.losjavaleros.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;
import utn.frba.losjavaleros.helpers.JsonHelper;
import utn.frba.losjavaleros.model.User;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users;
    @PostConstruct
    public void init() throws IOException {
        String file = "Users.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));
        TypeReference typeReference = new TypeReference<List<User>>() {
        };
        users = (List<User>) JsonHelper.parse(json, typeReference);

    }

    public User findByUsername(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username) ).findFirst().orElse(null);
    }
    public void addUser(User user){
        users.add(user);
    }
}
