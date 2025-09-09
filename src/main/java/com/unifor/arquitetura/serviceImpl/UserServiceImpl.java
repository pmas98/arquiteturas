package com.unifor.arquiteturas.serviceImpl;

import com.unifor.arquiteturas.models.User;
import com.unifor.arquiteturas.repository.UserRepository;
import com.unifor.arquiteturas.services.UserIterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserIterface {
    
    @Autowired
    private UserRepository repository;

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> GetAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUseById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElse(null);
    }
}
