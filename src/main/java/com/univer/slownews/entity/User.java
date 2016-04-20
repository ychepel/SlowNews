package com.univer.slownews.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "`user`")
public class User {
    @Id
    @SequenceGenerator(name="user_id_seq",
            sequenceName="user_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="user_id_seq")
    private int id;
    private String name;
    private String password;
    private String email;

    @OneToMany(mappedBy="user", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<News> news;

    public User(String name, String email, String password) {
        setName(name);
        setPassword(password);
        setEmail(email);
    }

    public User() {}

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
