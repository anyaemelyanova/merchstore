package ru.java.merchStore.repository;

import org.springframework.data.repository.CrudRepository;
import ru.java.merchStore.domain.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findAll();

}
