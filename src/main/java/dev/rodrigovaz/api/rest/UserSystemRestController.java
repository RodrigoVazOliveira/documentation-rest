package dev.rodrigovaz.api.rest;

import dev.rodrigovaz.api.model.UserSystem;
import dev.rodrigovaz.api.repository.UserSystemRespository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Usuário de sistema", description = "RESTful para CRUD do usuário de sistema")
public class UserSystemRestController {
    private final UserSystemRespository userSystemRespository;

    public UserSystemRestController(UserSystemRespository userSystemRespository) {
        this.userSystemRespository = userSystemRespository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Obter todos os usuários", summary = "Obter todos os usuários")
    List<UserSystem> getUsers() {
        return userSystemRespository.findAll();
    }

    @GetMapping(value = "/{login}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Obter um usuário por nome do login", summary = "Obter um usuário por nome do login")
    UserSystem getByLogin(@PathVariable("login") final String login) {
        return userSystemRespository.findByLogin(login);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(description = "Deleta um usuário por id", summary = "Deleta um usuário por id")
    void deleteById(@PathVariable("id") final Long id) {
        userSystemRespository.deleteById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Cadastra um novo usuário", summary = "Cadastra um novo usuário")
    void createUser(@RequestBody final UserSystem userSystem) {
        userSystemRespository.save(userSystem);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(description = "Atualiza um usuário", summary = "Atualiza um usuário")
    void updateUserSystem(@RequestBody UserSystem userSystem) {
        userSystemRespository.save(userSystem);
    }
}
