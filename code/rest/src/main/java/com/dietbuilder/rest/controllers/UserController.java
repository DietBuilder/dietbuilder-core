package com.dietbuilder.rest.controllers;

import com.dietbuilder.api.UsersApi;
import com.dietbuilder.model.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController implements UsersApi {
    @Override
    public ResponseEntity<UserDto> getUserById(String body) {
        return new ResponseEntity<>(new UserDto().email("test email").id(1234L), HttpStatus.ACCEPTED);
    }
}
