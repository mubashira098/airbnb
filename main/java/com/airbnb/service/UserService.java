package com.airbnb.service;

import com.airbnb.dto.PropertyUserDto;
import com.airbnb.entity.PropertyUser;
import com.airbnb.repository.PropertyUserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private PropertyUserRepository propertyUserRepository;

    // Constructor-based injection of the repository
    public UserService(PropertyUserRepository propertyUserRepository) {
        this.propertyUserRepository = propertyUserRepository;
    }

    // Add user method, now accepting a PropertyUserDto
    public PropertyUserDto addUser(PropertyUserDto propertyUserDto) {
        // Map PropertyUserDto to PropertyUser entity
        PropertyUser user = new PropertyUser();
        user.setFirstName(propertyUserDto.getFirstName());
        user.setLastName(propertyUserDto.getLastName());
        user.setUsername(propertyUserDto.getUsername());
        user.setEmail(propertyUserDto.getEmail());
        user.setPassword(BCrypt.hashpw(propertyUserDto.getPassword(), BCrypt.gensalt(10)));  // Encrypt the password
        user.setUserRole(propertyUserDto.getUserRole());

        // Save the PropertyUser entity to the database
        PropertyUser savedUser = propertyUserRepository.save(user);

        // Convert saved PropertyUser entity to PropertyUserDto
        PropertyUserDto savedUserDto = new PropertyUserDto();
        savedUserDto.setFirstName(savedUser.getFirstName());
        savedUserDto.setLastName(savedUser.getLastName());
        savedUserDto.setUsername(savedUser.getUsername());
        savedUserDto.setEmail(savedUser.getEmail());
        savedUserDto.setUserRole(savedUser.getUserRole());

        // Return the PropertyUserDto object
        return savedUserDto;
    }
}

