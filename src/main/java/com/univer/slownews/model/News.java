package com.univer.slownews.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name = "news")
@XmlAccessorType(XmlAccessType.FIELD)
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "description")
    private String body;
    @Column(name = "source_link")
    @XmlElement(name = "link")
    private String url;
    @Embedded
    @XmlElement(name = "enclosure")
    private NewsImageLink imageLink = new NewsImageLink();
    @ManyToOne(fetch=FetchType.LAZY)
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public News() {
    }

    public News(String title, String body, String teaserLink, String url) {
        this.title = title;
        this.body = body;
        this.imageLink.setUrl(teaserLink);
        this.url = url;
    }

    public News(int id, String title, String body, String teaserLink, String url) {
        this.id = id;
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

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}
}
