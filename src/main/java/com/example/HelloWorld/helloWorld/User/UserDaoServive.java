package com.example.HelloWorld.helloWorld.User;

import com.example.HelloWorld.helloWorld.Model.Post;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import javafx.geometry.Pos;

import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoServive {

    private static int usersCount = 3;

    private static List<User> users =  new ArrayList<>();
    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "jack", new Date()));

        for (User user : users) {
            user.setPosts(createPosts(user.getId()));
        }
    }

    private static List<Post> createPosts(Integer id) {
        List<Post> posts = new ArrayList<>();
        for (Integer i = 0; i < id; ++i) {
            posts.add(new Post("Post # " + (i + 1) + " for User # " + id));
        }
        return posts;
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if(user.getId() == null) {
            user.setId(++usersCount);
        }
        user.setPosts(new ArrayList<>());
        users.add(user);
        return user;
    }

    public User findOne(Integer id) {
        for (User user:users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public Boolean deleteUser(Integer id) {
        for(User user : users) {
            if(user.getId() == id) {
                users.remove(user);
                usersCount--;
                return true;
            }
        }
        return false;
    }

    public List<Post> getUserPosts(Integer id) {
        List<Post> posts = this.findOne(id).getPosts() ;
        if(posts == null) {
            return new ArrayList<>();
        }
        return posts;
    }

    public Boolean savePost(User user, Post post) {
        if(user == null || post == null) {
            throw new NullPointerException("User or Post can't be null");
        }
        return user.addPost(post);
    }
}
