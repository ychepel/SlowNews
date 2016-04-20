package com.univer.slownews.entity;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="rss")
public class RSSNews {

    @XmlElementWrapper(name="channel")
    @XmlElement(name="item")
    private List<News> newsList;

    public List<News> getNewsList() {
        return newsList;
    }

}
