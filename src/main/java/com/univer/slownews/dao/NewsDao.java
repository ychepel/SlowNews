package com.univer.slownews.dao;

import com.univer.slownews.model.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDao {
    private DaoFactory daoFactory = new DaoFactory();

    public List<News> getNewsByUser(String userName) throws DaoException {
        String sql = "SELECT * FROM \"NEWS\" WHERE USER_ID=?";
        List<News> news = new ArrayList<>();

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            int id = new UserDao().getIdByName(userName);
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    String title = resultSet.getString("TITLE");
                    String body = resultSet.getString("BODY");
                    String imageLink = resultSet.getString("TEASER_LINK");
                    String sourceLink = resultSet.getString("SOURCE_LINK");
                    News currentNews = new News(title, body, imageLink, sourceLink);
                    news.add(currentNews);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot add get news for user from DB", e);
        }
        return news;
    }

    public void addNews(String userName, News news) throws DaoException {
        String sql = "INSERT INTO \"NEWS\" (USER_ID, TITLE, BODY, TEASER_LINK, SOURCE_LINK) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            int id = new UserDao().getIdByName(userName);
            statement.setInt(1, id);
            statement.setString(2, news.getTitle());
            statement.setString(3, news.getBody());
            statement.setString(4, news.getTeaserLink());
            statement.setString(5, news.getUrl());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Cannot add news to DB", e);
        }
    }
}
