package org.example.user.core;

import org.example.user.core.model.User;
import org.example.user.core.ports.incoming.UserInputPort;
import org.example.user.core.ports.outgoing.UserOutputPort;

import java.util.UUID;

public class UserService {
    private UserOutputPort userOutputPort;

    //private ExternalResource externalResource;


    public UUID addNewUser(UserInputPort.UserDetails userDetails) {
        User user = new User(
                UUID.randomUUID(),
                userDetails.getEmail(),
                userDetails.getFirstName(),
                userDetails.getLastName()
        );
        return userOutputPort.persistUser(user);
    }
}
