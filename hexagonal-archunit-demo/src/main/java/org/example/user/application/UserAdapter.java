package org.example.user.application;

import org.example.user.core.UserService;
import org.example.user.core.ports.incoming.UserInputPort;

import java.util.UUID;

public class UserAdapter implements UserInputPort {
    private UserService userService;

    @Override
    public UUID addNewUser(UserDetails addUserRequest) {
        return userService.addNewUser(addUserRequest);
    }
}
