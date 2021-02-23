package ru.java.merchStore.repository;

import org.springframework.data.repository.CrudRepository;
import ru.java.merchStore.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
