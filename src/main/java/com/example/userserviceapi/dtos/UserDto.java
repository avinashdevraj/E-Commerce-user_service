package com.example.userserviceapi.dtos;

import com.example.userserviceapi.models.Role;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private String username;
    private String email;
    @ManyToMany
    private List<Role> roles;
    private boolean isEmailVerified;

    public  static UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmailVerified(user.getRoles());
        return userDto;

    }


}
