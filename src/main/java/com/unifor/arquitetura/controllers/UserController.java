package com.unifor.arquiteturas.controllers;

import com.unifor.arquiteturas.models.User;
import com.unifor.arquiteturas.services.UserIterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cadastrar-usuario")
public class UserController {

    private UserIterface userIterface;

    @PostMapping("/create")
    public ResponseEntity<User> CreateUser(@RequestBody  User user) {
        return ResponseEntity.ok(userIterface.createUser(user));
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userIterface.GetAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@RequestParam long id) {
        return ResponseEntity.ok(userIterface.getUseById(id));
    }

}
