package org.example.user.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class User {
    private UUID id;
    private String email;
    private String firstName;
    private String lastName;

}
