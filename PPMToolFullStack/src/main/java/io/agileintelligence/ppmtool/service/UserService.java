package io.agileintelligence.ppmtool.service;

import io.agileintelligence.ppmtool.domain.User;
import io.agileintelligence.ppmtool.exceptions.UsernameAlreadyExistsException;
import io.agileintelligence.ppmtool.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;


    /* note: security, we will create the bean in main method*/
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User saveUser(User newUser){
        try {
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
            return userRepository.save(newUser);
        }catch (Exception ex){
            throw new UsernameAlreadyExistsException("username "+newUser.getUsername()+" already exist");
        }

    }

}