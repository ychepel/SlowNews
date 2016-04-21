package com.univer.slownews.dao;

import com.univer.slownews.model.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDao {
    private ConnectionFactory connectionFactory = new ConnectionFactory();

    public List<News> getNewsByUser(String userName) throws DaoException {
        String sql = "SELECT N.* FROM news N INNER JOIN \"user\" U ON N.user_id=U.id WHERE U.name=?";
        List<News> news = new ArrayList<>();

        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, userName);

            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String title = resultSet.getString("title");
                    String body = resultSet.getString("body");
                    String imageLink = resultSet.getString("teaser_link");
                    String sourceLink = resultSet.getString("source_link");
                    News currentNews = new News(id, title, body, imageLink, sourceLink);
                    news.add(currentNews);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot add get news for user from DB", e);
        }
        return news;
    }

    public void addNews(String userName, News news) throws DaoException {
        String sql = "INSERT INTO news (user_id, title, body, teaser_link, source_link) " +
                "(SELECT id, ?, ?, ?, ? FROM \"user\" WHERE name=?)";

        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, news.getTitle());
            statement.setString(2, news.getBody());
            statement.setString(3, news.getTeaserLink());
            statement.setString(4, news.getUrl());
            statement.setString(5, userName);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Cannot add news to DB", e);
        }
    }

    public void removeNewsById(List<Integer> newsId) throws DaoException {
        String sql = "DELETE FROM news WHERE id=?";

        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            for(Integer id : newsId) {
                statement.setInt(1, id);
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            throw new DaoException("Cannot delete news by ID from DB", e);
        }
    }
}
