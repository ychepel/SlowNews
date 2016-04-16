package com.univer.slownews.service;

import com.univer.slownews.dao.DaoException;
import com.univer.slownews.dao.NewsDao;
import com.univer.slownews.model.News;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsStorage {
    public void addNews(String userName, News news) throws ServiceException {
        NewsDao newsDao = new NewsDao();
        try {
            newsDao.addNews(userName, news);
        } catch (DaoException e) {
            throw new ServiceException("Cannot add news into DB", e);
        }
    }

    public List<News> getUserNews(String userName) throws ServiceException {
        NewsDao newsDao = new NewsDao();
        try {
            List<News> news = newsDao.getNewsByUser(userName);
            return news;
        } catch (DaoException e) {
            throw new ServiceException("Cannot get news for user from DB", e);
        }
    }

    public void removeNews(List<Integer> newsId) throws ServiceException {
        NewsDao newsDao = new NewsDao();
        try {
            newsDao.removeNewsById(newsId);
        } catch (DaoException e) {
            throw new ServiceException("Cannot remove archive news from DB", e);
        }
    }

}
