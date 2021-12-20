package org.example.user.infrastructure.persistence;

import org.example.user.core.model.User;
import org.example.user.core.ports.outgoing.UserRepository;

import java.util.UUID;

class UserRepositoryAdapter implements UserRepository {
    private SpringDataUserRepository userRepository;

    //1 adapters should not know about other adapters
    //private UserFacade userFacade;

    @Override
    public UUID save(User user) {
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }
}
