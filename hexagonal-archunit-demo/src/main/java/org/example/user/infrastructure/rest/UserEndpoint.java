package org.example.user.infrastructure.rest;

import org.example.user.core.model.AddUserRequest;
import org.example.user.core.ports.incoming.AddNewUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/users")
class UserEndpoint {
    private AddNewUser addNewUser;

    @PostMapping
    public ResponseEntity<String> addNewUser(@RequestBody AddUserRequest addUserCommand) {
        UUID uuid = addNewUser.addNewUser(addUserCommand);
        return ResponseEntity.created(URI.create("/users/" + uuid.toString())).build();
    }
}
