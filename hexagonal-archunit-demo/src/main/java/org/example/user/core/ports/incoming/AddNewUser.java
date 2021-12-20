package org.example.user.core.ports.incoming;

import org.example.user.core.model.AddUserRequest;

import java.util.UUID;

public interface AddNewUser {
    UUID addNewUser(AddUserRequest addUserRequest);
}
