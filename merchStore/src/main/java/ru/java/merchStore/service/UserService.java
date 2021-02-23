package ru.java.merchStore.service;

import ru.java.merchStore.domain.User;
import ru.java.merchStore.domain.security.UserRole;

import java.util.Set;

public interface UserService {

    User createUser(User user, Set<UserRole> userRoles);
}
