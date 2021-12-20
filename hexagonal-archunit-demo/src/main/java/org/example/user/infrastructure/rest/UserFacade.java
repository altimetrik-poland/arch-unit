package org.example.user.infrastructure.rest;

import org.example.user.core.UserService;
import org.example.user.core.model.AddUserRequest;
import org.example.user.core.ports.incoming.AddNewUser;

import java.util.UUID;

public class UserFacade implements AddNewUser {
    private UserService userService;

    @Override
    public UUID addNewUser(AddUserRequest addUserRequest) {
        return userService.addNewUser(
                addUserRequest.getEmail(),
                addUserRequest.getFirstName(),
                addUserRequest.getLastName()
        );
    }
}
