package com.dietbuilder.domain.daos;

import com.dietbuilder.domain.exceptions.UserNotFoundException;
import com.dietbuilder.domain.repositories.UserRepository;
import com.dietbuilder.domain.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDao  {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new UserNotFoundException("Cannot find user with id: " + id);
        }
    }

}
