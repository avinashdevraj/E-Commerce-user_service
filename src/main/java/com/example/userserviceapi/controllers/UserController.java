package com.example.userserviceapi.controllers;

import com.example.userserviceapi.dtos.*;
import com.example.userserviceapi.exceptions.InvalidPasswordException;
import com.example.userserviceapi.exceptions.InvalidTokenException;
import com.example.userserviceapi.models.Token;
import com.example.userserviceapi.models.User;
import com.example.userserviceapi.services.UserService;
import jakarta.ws.rs.Path;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup") // localhost:8080/users/signup
    public UserDto signUp(@RequestBody SignUpRequestDto requestDto) {
        User user = userService.signUp(
                requestDto.getEmail(),
                requestDto.getPassword(),
                requestDto.getName()
        );

        //get UserDto from User;
        return UserDto.from(user);
    }

    @PostMapping("/login") // localhost:8080/users/login
    public LogInResponseDto login(@RequestBody LogInRequestDto requestDto) throws InvalidPasswordException {
        Token token = userService.login(requestDto.getEmail(),
                requestDto.getPassword());

        LogInResponseDto responseDto = new LogInResponseDto();
        responseDto.setToken(token);

        return responseDto;
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logOut(@RequestBody LogOutRequestDto requestDto) throws InvalidTokenException {
        ResponseEntity<Void> responseEntity = null;
        try {
            userService.logout(requestDto.getToken());
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Something went wrong");
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PostMapping("/validate/{token}")
    public UserDto validateToken(@PathVariable String token) throws InvalidTokenException {
        return UserDto.from(userService.validateToken(token));
    }

    @GetMapping("/{id}")
    public String getUserDetails(@PathVariable("id") Long userId) {
        System.out.println("Received request for getUserDetails");
        return "Hello from user with id: " + userId;
    }
}