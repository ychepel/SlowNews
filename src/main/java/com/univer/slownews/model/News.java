package com.univer.slownews.model;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class News {
    @XmlElement(name="title")
    private String title;

    @XmlElement(name="description")
    private String body;

    @XmlElement(name="enclosure")
    private String teaserLink;

    @XmlElement(name="link")
    private String url;

    public News() {
    }

    public News(String title, String body, String teaserLink, String url) {
        this.title = title;
        this.body = body;
        this.teaserLink = teaserLink;
        this.url = url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTeaserLink(String teaserLink) {
        this.teaserLink = teaserLink;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getTeaserLink() {
        return teaserLink;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
