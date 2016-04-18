package com.univer.slownews.hibernate;

import com.univer.slownews.hibernate.NewsEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"USER\"")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID\"")
    private int id;
    @Column(name = "\"NAME\"")
    private String name;
    @Column(name = "\"PASSWORD\"")
    private String password;
    @Column(name = "\"EMAIL\"")
    private String email;

    @OneToMany
    @JoinColumn(name="\"USER_ID\"", nullable = false)
    private List<NewsEntity> archiveNews = new ArrayList<>();

    public UserEntity(String name, String email, String password) {
        setName(name);
        setPassword(password);
        setEmail(email);
    }

    public UserEntity() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {this.password = password;}

    public String getEmail() {return email;}

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
