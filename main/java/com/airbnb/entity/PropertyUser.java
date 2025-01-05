package com.airbnb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name="user")
public class PropertyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,length = 150)
    private Long id;
    @Column(name="first_name",nullable = false,length = 150)
    private String firstName;
    @Column(name="last_name",nullable = false,length = 150)
    private String lastName;
    @Column(name = "username",nullable = false,unique = true)
    private String username;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "password", nullable = false, length = 150)
    private String password;
    @Column(name = "user_role",nullable = false,length = 20)
    private String userRole;




}
