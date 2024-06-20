package com.example.productservice.dto;



import lombok.Getter;

import java.util.List;
@Getter
public class UserDto {
    private String name;

    private String email;

    private List<Roles> roles;
    private boolean isEmailVerified;

}
