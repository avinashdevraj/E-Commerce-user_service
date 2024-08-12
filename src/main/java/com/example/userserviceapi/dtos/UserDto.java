package com.example.userserviceapi.dtos;

import com.example.userserviceapi.models.Role;
import com.example.userserviceapi.models.User;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private String name;
    private String email;
    @ManyToMany
    private List<Role> roles;
    private boolean isEmailVerified;;

    public static UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setEmailVerified(user.isEmailVerified());
        userDto.setRoles(user.getRoles());

        return userDto;
    }
}