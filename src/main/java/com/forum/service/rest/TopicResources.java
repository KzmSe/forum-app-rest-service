package com.forum.service.rest;

import com.forum.service.dao.TopicDaoImpl;
import com.forum.service.exceptions.TopicCredentialsException;
import com.forum.service.model.Comment;
import com.forum.service.model.ResponseModel;
import com.forum.service.model.Topic;
import com.forum.service.service.TopicService;
import com.forum.service.service.TopicServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("topics")
public class TopicResources {

    private TopicService topicService = new TopicServiceImpl(new TopicDaoImpl());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel getAllTopics() throws SQLException {
        List<Topic> list = topicService.getAllTopic();
        ResponseModel responseModel = new ResponseModel();
        responseModel.withStatusSuccess();
        responseModel.setBody(list);
        return responseModel;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel getTopicById(@PathParam("id") int id) throws SQLException, TopicCredentialsException {
        Topic topic = topicService.getTopicById(id);
        ResponseModel responseModel = new ResponseModel();
        responseModel.withStatusSuccess();
        responseModel.setBody(topic);
        return responseModel;
    }

    @GET
    @Path("/popular")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel getPopularTopics() throws SQLException {
        List<Topic> list = topicService.getPopularTopics();
        ResponseModel responseModel = new ResponseModel();
        responseModel.withStatusSuccess();
        responseModel.setBody(list);
        return responseModel;
    }

    @GET
    @Path("/similar")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel getSimilarTopics(@QueryParam("keywords") List<String> keywords) throws SQLException {
        List<Topic> list = topicService.getSimilarTopics(keywords.toArray(new String[]{}));
        ResponseModel responseModel = new ResponseModel();
        responseModel.withStatusSuccess();
        responseModel.setBody(list);
        return responseModel;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseModel addTopic(Topic topic) throws SQLException {
        Topic addedTopic = topicService.addTopic(topic);
        ResponseModel responseModel = new ResponseModel();
        responseModel.withStatusSuccess();
        responseModel.setBody(addedTopic);
        return responseModel;
    }

    @PUT
    @Path("/{id}/viewCount")
    public Response incrementTopicViewCount(@PathParam("id") int id) throws SQLException, TopicCredentialsException {
        //Lets check if topic exists
        topicService.getTopicById(id);

        topicService.incrementTopicViewCount(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel getCommentsByTopicId(@PathParam("id") int id) throws SQLException, TopicCredentialsException {
        //Lets check if topic exists
        topicService.getTopicById(id);

        List<Comment> list = topicService.getCommentsByTopicId(id);
        ResponseModel responseModel = new ResponseModel();
        responseModel.withStatusSuccess();
        responseModel.setBody(list);
        return responseModel;
    }



}
