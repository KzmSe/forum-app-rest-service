package com.forum.service.dao;

import com.forum.service.exceptions.TopicCredentialsException;
import com.forum.service.model.Comment;
import com.forum.service.model.Topic;

import java.sql.SQLException;
import java.util.List;

public interface TopicDao {

    List<Topic> getAllTopic() throws SQLException;

    Topic getTopicById(int id) throws SQLException, TopicCredentialsException;

    void incrementTopicViewCount(int id) throws SQLException;

    Topic addTopic(Topic topic) throws SQLException;

    List<Topic> getPopularTopics() throws SQLException;

    List<Topic> getAllTopicsByUserId(int id) throws SQLException;

    List<Topic> getSimilarTopics(String[] keywords) throws SQLException;

    Comment addComment(Comment comment) throws SQLException;

    List<Comment> getCommentsByTopicId(int id) throws SQLException;

}
