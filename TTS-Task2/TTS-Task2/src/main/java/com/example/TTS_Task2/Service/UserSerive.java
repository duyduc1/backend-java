package com.example.TTS_Task2.Service;

import com.example.TTS_Task2.Entity.User;
import com.example.TTS_Task2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSerive {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User register(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public boolean login(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            User u = user.get();
            return passwordEncoder.matches(password, u.getPassword());
        }
        return false;
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
