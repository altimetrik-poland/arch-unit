package org.example.user.core.ports.outgoing;

import org.example.user.core.model.User;

import java.util.UUID;

public interface UserOutputPort {
    UUID persistUser(User user);
}
