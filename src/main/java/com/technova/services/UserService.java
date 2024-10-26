package com.technova.services;

import com.technova.domain.entity.User;
import com.technova.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class UserService {

    private UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void createUser(User user) {
        user.setDateExpiration(LocalDate.now().plusYears(1));
        user.setPieceIdentification(generateRandomIdentifier());
        userRepository.save(user);
    }

    public void updateUser(Long id, User user) {
        user.setId(id);
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }



    private String generateRandomIdentifier() {
        Random random = new Random();
        StringBuilder identifier = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            char letter = (char) ('A' + random.nextInt(26));
            identifier.append(letter);
        }
        for (int i = 0; i < 4; i++) {
            int digit = random.nextInt(10);
            identifier.append(digit);
        }

        return identifier.toString();
    }

    public void setUserRepository(UserRepository userRepository) {
    }
}
