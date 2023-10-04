package dev.rodrigovaz.api.rest;

import dev.rodrigovaz.api.model.UserSystem;
import dev.rodrigovaz.api.repository.UserSystemRespository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
}
