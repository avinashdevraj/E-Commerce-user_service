package com.example.userserviceapi.dtos;

import com.example.userserviceapi.models.Token;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogOutRequestDto {
    private Token token;
}
