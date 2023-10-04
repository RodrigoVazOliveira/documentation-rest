package dev.rodrigovaz.api.repository;

import dev.rodrigovaz.api.model.UserSystem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserSystemRespository {

    public void save(UserSystem userSystem) {
        if (userSystem.getId() == null)
            System.out.println("SAVE - usuário sendo cadastrado na camada de repositório");

        System.out.println("UPDATE - usuário sendo atualizado na camada do repositório");
    }

    public void deleteById(final Long id) {
        System.out.printf("DELETE/%d - excluir usuário\n", id);
    }

    public List<UserSystem> findAll() {
        System.out.println("LIST - criando lista de usuários");
        final List<UserSystem> userSystems = new ArrayList<>();
        userSystems.add(new UserSystem(1L, "xpto", "xpto234324"));
        userSystems.add(new UserSystem(2L, "xpto", "xpto234324"));
        userSystems.add(new UserSystem(2L, "xpto", "xpto234324"));

        return userSystems;
    }

    public UserSystem findById(final Long id) {
        System.out.printf("FINDBYID - %id \n", id);

        return new UserSystem(id, "XPTO", "23432432");
    }

    public UserSystem findByLogin(final String login) {
        System.out.printf("FIND BY LOGIN - %s", login);

        return new UserSystem(1L, login, "242343223");
    }
}
