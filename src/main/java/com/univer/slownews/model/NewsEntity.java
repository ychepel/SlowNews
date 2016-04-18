package com.univer.slownews.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "\"NEWS\"")
@XmlAccessorType(XmlAccessType.FIELD)
public class NewsEntity {
    @Column(name = "\"TITLE\"")
    @XmlElement(name = "title")
    private String title;

    @Column(name = "\"BODY\"")
    @XmlElement(name = "description")
    private String body;

    @Column(name = "\"SOURCE_LINK\"")
    @XmlElement(name = "link")
    private String url;

    @Embedded
    @XmlElement(name = "enclosure")
    private NewsImageLinkEntity imageLink = new NewsImageLinkEntity();

    @Id
    @Column(name = "\"ID\"")
    private int id;

    public NewsEntity() {
    }

    public NewsEntity(String title, String body, String teaserLink, String url) {
        this.title = title;
        this.body = body;
        this.imageLink.setUrl(teaserLink);
        this.url = url;
    }

    public NewsEntity(int id, String title, String body, String teaserLink, String url) {
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
