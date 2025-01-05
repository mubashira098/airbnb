package com.airbnb.dto;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PropertyUserDto {


        private Long id;
        private String firstName;
        private String lastName;
        private String username;
        private String email;
        private String password;
        private String userRole;




    }


