package com.univer.slownews.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class News {
    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "description")
    private String body;

    @XmlElement(name = "link")
    private String url;

    @XmlElement(name = "enclosure")
    private NewsImageLink imageLink = new NewsImageLink();

    public News() {
    }

    public News(String title, String body, String teaserLink, String url) {
        this.title = title;
        this.body = body;
        this.imageLink.setUrl(teaserLink);
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTeaserLink() {
        return imageLink.getUrl();
    }

    public void setTeaserLink(String teaserLink) {
        this.imageLink.setUrl(teaserLink);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
