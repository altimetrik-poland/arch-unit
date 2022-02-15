package org.example.user.core;

import org.example.user.core.model.User;
import org.example.user.core.ports.incoming.UserInputPort;
import org.example.user.core.ports.outgoing.UserOutputPort;

import java.util.UUID;


//4 domain must be independent
//@Component
public class UserService {
    private UserOutputPort userOutputPort;

    //3 must not depend on external packages
    //private ExtResource extResource;

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
