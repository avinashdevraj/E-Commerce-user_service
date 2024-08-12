package com.example.userserviceapi.services;

import com.example.userserviceapi.models.Token;
import com.example.userserviceapi.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
     private UserRepository userRepository;
     private BCryptPasswordEncoder bCryptPasswordEncoder;
     UserService(UserRepository userRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
         this.userRepository = userRepository;
         this.bCryptPasswordEncoder = bCryptPasswordEncoder;
     }

     public User signUp(String name, String email, String password){
         Optional<User> optionalUser = userRepository.findByEmail(email);

         if(optionalUser.isPresent()){
             return optionalUser.get();
         }
         User user = new User();
         user.setUsername(name);
         user.setPassword(bCryptPasswordEncoder.encode(password));
         return userRepository.save(user);

     }

     public Token login(String email, String password){
         return null;
     }

     public void logout(Token token){
         return;
     }

}
