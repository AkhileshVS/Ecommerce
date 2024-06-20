package com.example.productservice.Commns;

import com.example.productservice.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;
@Service
public class AuthenticationCommons {
    private RestTemplate restTemplate;
    AuthenticationCommons(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public UserDto validateToken(String token){

       ResponseEntity<UserDto> userRespone =  restTemplate.postForEntity(
                "http://localhost:8181/user/validate/"+token,
                null,
                UserDto.class
        );
       if(!userRespone.hasBody()){
           return null;
       }
        return userRespone.getBody();
    }
}
