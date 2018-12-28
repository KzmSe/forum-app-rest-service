package com.forum.service.service;

import com.forum.service.dao.TopicDao;
import com.forum.service.exceptions.TopicCredentialsException;
import com.forum.service.model.Comment;
import com.forum.service.model.Topic;

import java.sql.SQLException;
import java.util.List;

public class TopicServiceImpl implements TopicService {

    private TopicDao topicDao;

    public TopicServiceImpl(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    @Override
    public List<Topic> getAllTopic() throws SQLException {
        return topicDao.getAllTopic();
    }

    @Override
    public Topic getTopicById(int id) throws SQLException, TopicCredentialsException {
        return topicDao.getTopicById(id);
    }

    @Override
    public void incrementTopicViewCount(int id) throws SQLException {
        topicDao.incrementTopicViewCount(id);
    }

    @Override
    public Topic addTopic(Topic topic) throws SQLException {
        return topicDao.addTopic(topic);
    }

    @Override
    public List<Topic> getPopularTopics() throws SQLException {
        return topicDao.getPopularTopics();
    }

    @Override
    public List<Topic> getAllTopicsByUserId(int id) throws SQLException {
        return topicDao.getAllTopicsByUserId(id);
    }

    @Override
    public List<Topic> getSimilarTopics(String[] keywords) throws SQLException {
        return topicDao.getSimilarTopics(keywords);
    }

    @Override
    public Comment addComment(Comment comment) throws SQLException {
        return topicDao.addComment(comment);
    }

    @Override
    public List<Comment> getCommentsByTopicId(int id) throws SQLException {
        return topicDao.getCommentsByTopicId(id);
    }
}