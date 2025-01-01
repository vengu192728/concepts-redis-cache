package com.example.redisexample.service;


import com.example.redisexample.model.User;
import com.example.redisexample.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        logger.info("Adding new user data {}",user);
        return userRepository.save(user);

    }

    @Cacheable(value = "users", key = "#id")
    public Optional<User> getUserById(Long id) {
        logger.info("Fetching from database...");
        Optional<User> user = userRepository.findById(id);
        logger.info("Fetched data from DB {}",user);
        return user;
    }

    @CachePut(value = "users", key = "#user.id")
    public User updateUser(User user) {
        logger.info("Updating user");
        return userRepository.save(user);
    }

    @CacheEvict(value = "users", key = "#id")
    public void deleteUserById(Long id) {
        logger.info("Deleting user {}", id);
        userRepository.deleteById(id);
    }
}
