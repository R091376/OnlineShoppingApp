package com.onlineshopping.userms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshopping.userms.exception.UserNotFoundException;
import com.onlineshopping.userms.model.User;
import com.onlineshopping.userms.repository.UserRepository;


@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User updateUser(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setEmail(updatedUser.getEmail());
            return userRepository.save(existingUser);
        }
        throw new UserNotFoundException("user not found with id :"+id);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

	public User login(User user) {
		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
}
