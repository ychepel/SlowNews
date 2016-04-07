package com.univer.slownews.model;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="rss")
public class News {
    @XmlPath("channel/title")
    private String title;

    @XmlPath("channel/description")
    private String body;

    @XmlPath("channel/enclosure")
    private String teaserLink;

    @XmlPath("channel/link")
    private String url;

    public News() {
    }

    public News(String title, String body, String teaserLink, String url) {
        this.title = title;
        this.body = body;
        this.teaserLink = teaserLink;
        this.url = url;
    }

    @XmlElement
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    @XmlElement
    public String getTeaserLink() {
        return teaserLink;
    }
    public void setTeaserLink(String teaserLink) {
        this.teaserLink = teaserLink;
    }

    @XmlElement
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
