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

    public void deleteById(Long id) {
        System.out.println("DELETE - excluir usuário");
        System.out.println(id);
    }

    public List<UserSystem> findAll() {
        System.out.println("LIST - criando lista de usuários");
        final List<UserSystem> userSystems = new ArrayList<>();
        userSystems.add(new UserSystem(1L, "xpto", "xpto234324"));
        userSystems.add(new UserSystem(2L, "xpto", "xpto234324"));
        userSystems.add(new UserSystem(2L, "xpto", "xpto234324"));

        return userSystems;
    }


}
