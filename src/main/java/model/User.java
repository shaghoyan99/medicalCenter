package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import util.PasswordUtil;

import java.io.Serializable;
import java.security.CryptoPrimitive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private String id;
    private String name;
    private String surName;
    private String email;
    private String password;
    private Role role;



}
