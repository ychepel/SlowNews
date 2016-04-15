package com.univer.slownews.service;

import com.univer.slownews.model.News;

import java.util.List;

public interface NewsProvider {
    List<News> getNews() throws ServiceException;
}
