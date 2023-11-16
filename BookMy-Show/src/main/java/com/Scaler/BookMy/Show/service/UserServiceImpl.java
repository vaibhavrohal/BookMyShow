package com.Scaler.BookMy.Show.service;

import com.Scaler.BookMy.Show.exceptions.InvalidCredentialsException;
import com.Scaler.BookMy.Show.exceptions.UserAlreadyExitsException;
import com.Scaler.BookMy.Show.exceptions.UserNotFoundException;

import com.Scaler.BookMy.Show.model.User;
import com.Scaler.BookMy.Show.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired

    UserRepository userRepository;

    @Override
    public User login(String email, String password) {
        //check email and password is present.if not present this will not give NPE
       Optional<User> useroptional= userRepository.findByEmail(email);

       if (useroptional.isEmpty()){
           throw new UserNotFoundException("user not available with email "+email);
       }
       //if available check password
       User user=useroptional.get();

       if (user.getPassword().equals(password)){
           return user;
       }
       else {
           throw new InvalidCredentialsException("Invalid credentials for user "+user);
       }

    }

    @Override
    public User signUp(String email, String password, String name) {
        Optional<User> optionalUser=userRepository.findByEmail(email);
        if (optionalUser.isPresent()){
           throw new UserAlreadyExitsException("user present with email "+email);
        }
        User user=new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        return userRepository.save(user);
    }
}
