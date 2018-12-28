package com.forum.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Action {

    private Integer id;
    private String actionType;
    private List<Role> roles;

}
