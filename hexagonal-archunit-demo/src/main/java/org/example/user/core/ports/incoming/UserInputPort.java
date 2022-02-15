package org.example.user.core.ports.incoming;

import java.util.UUID;

public interface UserInputPort {
    UUID addNewUser(UserDetails userDetails);

    class UserDetails {

        private final String email;
        private final String firstName;
        private final String lastName;

        public UserDetails(String email, String firstName, String lastName) {
            this.email = email;
            this.firstName = firstName;
            this.lastName = lastName;
        }


        public String getEmail() {
            return email;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }
}
