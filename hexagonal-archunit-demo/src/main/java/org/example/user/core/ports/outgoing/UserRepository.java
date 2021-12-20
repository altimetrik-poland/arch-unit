package org.example.user.core.ports.outgoing;

import org.example.user.core.model.User;

import java.util.UUID;

public interface UserRepository {
    UUID save(User user);
}
