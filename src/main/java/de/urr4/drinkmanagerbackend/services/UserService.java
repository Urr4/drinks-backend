package de.urr4.drinkmanagerbackend.services;

import de.urr4.drinkmanagerbackend.repositories.UserRepository;
import de.urr4.wine.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();

        Iterable<User> users = userRepository.findAll();
        users.forEach(allUsers::add);

        return allUsers;
    }

    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }
}
