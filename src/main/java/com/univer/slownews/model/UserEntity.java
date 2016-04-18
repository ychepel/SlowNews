package com.univer.slownews.model;

import org.hibernate.annotations.OptimisticLockType;

import javax.persistence.*;

@Entity
@Table(name = "\"USER\"")
public class UserEntity {
    @Id
    @Column(name = "\"ID\"")
    private int id;
    @Column(name = "\"NAME\"")
    private String name;
    @Column(name = "\"PASSWORD\"")
    private String password;
    @Column(name = "\"EMAIL\"")
    private String email;

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
