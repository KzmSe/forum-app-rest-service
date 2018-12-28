package com.forum.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private Integer id;
    private String description;
    private LocalDateTime writeDate;
    private Topic topic;
    private User user;

}
