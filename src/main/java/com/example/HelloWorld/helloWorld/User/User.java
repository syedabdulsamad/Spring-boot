package com.example.HelloWorld.helloWorld.User;

import com.example.HelloWorld.helloWorld.Model.Post;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@ApiModel
public class User {
    private Integer id;

    @JsonIgnore
    private String profession;

    @ApiModelProperty(notes = "Name should be at least 2 characters")
    @Size(min=2, message = "Name should be at least 2 chars")
    private String name;

    @ApiModelProperty(notes = "DOB can't be in future")
    @Past(message = "DOB can be in future")
    private Date birthDate;
    private List<Post> posts;

    public User(Integer id,
                String profession,
                @Size(min = 2, message = "Name should be at least 2 chars") String name,
                @Past(message = "DOB can be in future") Date birthDate) {
        this.id = id;
        this.profession = profession;
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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
