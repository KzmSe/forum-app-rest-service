package com.forum.service.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.forum.service.util.LocalDateTimeSerializer;
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
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime writeDate;
    private Topic topic;
    private User user;

}
