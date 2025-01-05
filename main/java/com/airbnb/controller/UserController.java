package com.airbnb.controller;

import com.airbnb.dto.PropertyUserDto;
import com.airbnb.entity.PropertyUser;
import com.airbnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
//hfhjkxj

//    mubashira first commit
    private final UserService userService;

    // Constructor-based injection (no need for @Autowired if you're using this)
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody PropertyUserDto propertyUserDto) {
        // Call the service to add the user
        PropertyUserDto propertyUser = userService.addUser(propertyUserDto);

        if (propertyUser != null) {
            return new ResponseEntity<>("Registration is successful", HttpStatus.CREATED);  // 201 for successful creation
        }

        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
