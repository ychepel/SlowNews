package com.univer.slownews.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
public class NewsImageLink {
    @Column(name = "teaser_link")
    @XmlAttribute(name="url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
