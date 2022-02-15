package org.example.user.core.ports.incoming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

public interface UserInputPort {
    UUID addNewUser(UserDetails userDetails);

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    class UserDetails {

        private String email;
        private String firstName;
        private String lastName;
    }
}
