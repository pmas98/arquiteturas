package com.unifor.arquitetura.services;

import com.unifor.arquitetura.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    
    User createUser(User user);    
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
}
