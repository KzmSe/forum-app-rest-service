package com.forum.service.rest;

import com.forum.service.dao.TopicDaoImpl;
import com.forum.service.model.Comment;
import com.forum.service.model.ResponseModel;
import com.forum.service.service.TopicService;
import com.forum.service.service.TopicServiceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("comments")
public class CommentResources {

    private TopicService topicService = new TopicServiceImpl(new TopicDaoImpl());

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseModel addComment(Comment comment) throws SQLException {
        Comment addedComment = topicService.addComment(comment);
        ResponseModel responseModel = new ResponseModel();
        responseModel.withStatusSuccess();
        responseModel.setBody(addedComment);
        return responseModel;
    }

}
