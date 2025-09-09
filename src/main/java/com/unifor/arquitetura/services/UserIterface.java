package com.unifor.arquiteturas.services;

import com.unifor.arquiteturas.models.User;

import java.util.List;

public interface UserIterface {

    public User createUser(User user);
    public List<User> GetAllUsers();
    public User getUseById(Long id);
}
