package dev.rodrigovaz.api.rest;

import dev.rodrigovaz.api.model.UserSystem;
import dev.rodrigovaz.api.repository.UserSystemRespository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserSystemRestController {
    private final UserSystemRespository userSystemRespository;

    public UserSystemRestController(UserSystemRespository userSystemRespository) {
        this.userSystemRespository = userSystemRespository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<UserSystem> getUsers() {
        return userSystemRespository.findAll();
    }

    @GetMapping("/{login}")
    UserSystem getByLogin(@PathVariable("login") final String login) {
        return userSystemRespository.findByLogin(login);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("id") final Long id) {
        userSystemRespository.deleteById(id);
    }
}
