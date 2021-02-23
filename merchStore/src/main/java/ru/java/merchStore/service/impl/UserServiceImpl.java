package ru.java.merchStore.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.java.merchStore.domain.User;
import ru.java.merchStore.domain.security.UserRole;
import ru.java.merchStore.repository.RoleRepository;
import ru.java.merchStore.repository.UserRepository;
import ru.java.merchStore.service.UserService;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles){
        User localUser = userRepository.findByUsername(user.getUsername());

        if(localUser != null){
            LOG.info("Пользователь с ником {} уже существует.",user.getUsername());
        } else{
            for(UserRole ur: userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);

            localUser = userRepository.save(user);
        }
        return localUser;
    }
}
