package com.univer.slownews.service;

import com.univer.slownews.dao.DaoException;
import com.univer.slownews.dao.SentencePartDao;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SentencePartStorage {

    private List<String> getParts(String type) throws ServiceException {
        SentencePartDao sentencePartDao = new SentencePartDao();
        try {
            List<String> parts = sentencePartDao.getParts(type);
            return parts;
        } catch (DaoException e) {
            throw new ServiceException("Cannot get sentence parts", e);
        }
    }

    public String getRandomElement(String type) throws ServiceException {
        List<String> parts = getParts(type);
        if(parts.size() > 0) {
            int randomElement = new Random().nextInt(parts.size());
            return parts.get(randomElement);
        }
        else {
            return "";
        }
    }

}
