package org.example.user.core;

import org.example.user.core.model.User;
import org.example.user.core.ports.outgoing.UserRepository;
import org.example.user.ext.ExternalResource;
import org.springframework.stereotype.Component;

import java.io.Externalizable;
import java.util.UUID;


//4 domain must be independent
//@Component
public class UserService {
    private UserRepository repository;

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
