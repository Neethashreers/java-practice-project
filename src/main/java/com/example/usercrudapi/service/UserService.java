package com.example.usercrudapi.service; 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usercrudapi.model.User;
import com.example.usercrudapi.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) 
    {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User newUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());
            user.setPhone(newUser.getPhone());
            return userRepository.save(user);
        }).orElse(null);
    }


    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
