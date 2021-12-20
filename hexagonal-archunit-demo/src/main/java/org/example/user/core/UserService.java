package org.example.user.core;

import org.example.user.core.model.User;
import org.example.user.core.ports.outgoing.UserRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;


//4 domain must be independent
//@Component
public class UserService {
    private UserRepository repository;

    //2 Domain must not know about technical infrastructures
    // private UserFacade facade;

    //3 must not depend on external packages
    //private ExtResource extResource;

    public UUID addNewUser(String email, String firstName, String lastName) {
        User user = new User(
                UUID.randomUUID(),
                email,
                firstName,
                lastName
        );
        return repository.save(user);
    }
}
