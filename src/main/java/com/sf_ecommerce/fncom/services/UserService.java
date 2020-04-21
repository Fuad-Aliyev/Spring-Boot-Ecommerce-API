package com.sf_ecommerce.fncom.services;

import com.sf_ecommerce.fncom.dto.request.UserDTO;
import com.sf_ecommerce.fncom.entities.users.User;
import com.sf_ecommerce.fncom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public boolean userExists(String email) {
        return userRepository.existsUsersByEmail(email);
    }
}
