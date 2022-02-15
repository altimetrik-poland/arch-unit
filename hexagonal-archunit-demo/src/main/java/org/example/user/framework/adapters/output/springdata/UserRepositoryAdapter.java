package org.example.user.framework.adapters.output.springdata;

import org.example.user.core.model.User;
import org.example.user.core.ports.outgoing.UserOutputPort;
import org.example.user.framework.adapters.input.stdin.UserCLIAdapter;

import java.util.UUID;

class UserRepositoryAdapter implements UserOutputPort {
    private SpringDataUserRepository userRepository;

    //1 adapters should not know about other adapters
    //private UserCLIAdapter userCLIAdapter;

    @Override
    public UUID persistUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }
}
