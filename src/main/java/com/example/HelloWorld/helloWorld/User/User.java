package com.example.HelloWorld.helloWorld.User;

import com.example.HelloWorld.helloWorld.Model.Post;


import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public class User {
    private Integer id;

    @Size(min=2, message = "Name should be at least 2 chars")
    private String name;
    @Past(message = "DOB can be in future")
    private Date birthDate;
    private List<Post> posts;

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", posts=" + posts +
                '}';
    }

    public Boolean addPost(Post post) {
       return posts.add(post);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
