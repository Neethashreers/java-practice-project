package com.example.usercrudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.usercrudapi.model.User;
import com.example.usercrudapi.service.UserService;

@RestController



@RequestMapping("/api/users")
public class UserController {

    @Autowired
    public UserService userService;
      
    @PostMapping
    public User createUser(@RequestBody User user) {
        System.out.println("Inside createUser, received user: " + user);
        return userService.saveUser(user);
    }

    @GetMapping("/test")
    public String test() {
        System.out.println("Inside test endpoint");
        return "API is working";
    }

    @GetMapping
    public List<User> getAllUsers() {
        System.out.println("Fetching all users");
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        System.out.println("Getting user by id: " + id);
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        System.out.println("Updating user id: " + id + " with data: " + user);
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        System.out.println("Deleting user id: " + id);
        if (userService.deleteUser(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
