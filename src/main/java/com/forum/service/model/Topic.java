package com.forum.service.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.forum.service.util.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Topic {

    private Integer id;
    private String title;
    private String description;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime shareDate;
    private Integer viewCount;
    private Integer commentsCount;
    private Integer status;
    private User user;
    private List<Comment> commentList;

    public Topic() {
        commentList = new ArrayList<>();
    }

    public void addComment(Comment comment) {
        commentList.add(comment);
    }

}