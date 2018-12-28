package com.forum.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String token;
    private String imagePath;
    private Integer status;
    private Role role;

}
