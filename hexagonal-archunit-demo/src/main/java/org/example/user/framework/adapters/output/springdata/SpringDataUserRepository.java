package org.example.user.framework.adapters.output.springdata;

import org.example.user.core.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SpringDataUserRepository extends CrudRepository<User, Long> {

}
