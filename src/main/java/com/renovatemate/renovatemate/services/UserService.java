package com.renovatemate.renovatemate.services;

import com.renovatemate.renovatemate.entities.User;
import com.renovatemate.renovatemate.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
    // at this stage of application, not yet used

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
    // at this stage of application, not yet used

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
    // at this stage of application, not yet used

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
