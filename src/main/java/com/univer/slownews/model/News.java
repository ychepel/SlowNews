package com.univer.slownews.model;

public class News {
    private String title;
    private String body;
    private String teaserLink;

    public News() {
    }

    public News(String title, String body, String teaserLink) {
        this.title = title;
        this.body = body;
        this.teaserLink = teaserLink;
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
}
