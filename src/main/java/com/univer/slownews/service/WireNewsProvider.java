package com.univer.slownews.service;

import com.univer.slownews.model.News;

import com.univer.slownews.model.RSSNews;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import javax.xml.bind.Unmarshaller;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WireNewsProvider implements NewsProvider {

    public List<News> getNews() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(RSSNews.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            RSSNews RSSNews = (RSSNews) jaxbUnmarshaller.unmarshal(new URL("http://newswire.net/rssfeeds/channel/feed/rss/newsroom"));
            return RSSNews.getNewsList();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
