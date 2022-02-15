package org.example.user.framework.adapters.input.rest;

import org.example.user.core.ports.incoming.UserInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserRestAdapter {
    private UserInputPort addNewUser;

    @PostMapping
    public ResponseEntity<String> addNewUser(@RequestBody UserInputPort.UserDetails addUserCommand) {
        UUID uuid = addNewUser.addNewUser(addUserCommand);
        return ResponseEntity.created(URI.create("/users/" + uuid.toString())).build();
    }
}
