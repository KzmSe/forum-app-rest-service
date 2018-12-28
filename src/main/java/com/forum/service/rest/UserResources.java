package com.forum.service.rest;

import com.forum.service.dao.TopicDaoImpl;
import com.forum.service.dao.UserDaoImpl;
import com.forum.service.exceptions.UserCredentialsException;
import com.forum.service.model.ResponseModel;
import com.forum.service.model.Topic;
import com.forum.service.model.User;
import com.forum.service.service.TopicService;
import com.forum.service.service.TopicServiceImpl;
import com.forum.service.service.UserService;
import com.forum.service.service.UserServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("users")
public class UserResources {

    private TopicService topicService = new TopicServiceImpl(new TopicDaoImpl());
    private UserService userService = new UserServiceImpl(new UserDaoImpl());

    @GET
    @Path("/{id}/topics")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel getAllTopicsByUserId(@PathParam("id") int id) throws SQLException {
        List<Topic> list = topicService.getAllTopicsByUserId(id);
        ResponseModel responseModel = new ResponseModel();
        responseModel.withStatusSuccess();
        responseModel.setBody(list);
        return responseModel;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseModel addUser(User user) throws UserCredentialsException, SQLException {
        User addedUser = userService.addUser(user);
        ResponseModel responseModel = new ResponseModel();
        responseModel.withStatusSuccess();
        responseModel.setBody(addedUser);
        return responseModel;
    }

    @GET
    @Path("/email/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel getUserByEmail(@PathParam("email") String email) throws UserCredentialsException, SQLException {
        User user = userService.getUserByEmail(email);
        ResponseModel responseModel = new ResponseModel();
        responseModel.withStatusSuccess();
        responseModel.setBody(user);
        return responseModel;
    }

}
