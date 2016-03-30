package com.univer.slownews.model;

public class News {
    private String title;
    private String body;
    private String teaserLink;
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
