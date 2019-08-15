package com.example.HelloWorld.helloWorld.Controller;


import com.example.HelloWorld.helloWorld.Exceptions.UserNotFoundException;
import com.example.HelloWorld.helloWorld.Model.Post;
import com.example.HelloWorld.helloWorld.User.User;
import com.example.HelloWorld.helloWorld.User.UserDaoService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {


    private UserDaoService service = new UserDaoService();

    @GetMapping(path = "/users")
    public List<User> getAllUSers() {
        return service.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable int id) {

        User user = service.findOne(id);
        if(user == null) {
            throw new UserNotFoundException("id :" + id);
        }
        return user;
    }

    @PostMapping(path = "/users")
    public ResponseEntity saveUser(@Valid @RequestBody User user) {
        User createdUser =  service.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public Boolean deleteUser(@PathVariable  Integer id) {
        return service.deleteUser(id);
    }

/////////////////////////POSTS//////////////////////////////////

    @GetMapping(path = "/users/{id}/posts")
    public List<Post> getUserPosts(@PathVariable Integer id) {
        return service.getUserPosts(id);
    }

    @PostMapping(path = "/users/{id}/posts")
    public Boolean savePost(@PathVariable Integer id, @RequestBody Post post) {
        User user = getUser(id);
        return service.savePost(user, post);
    }



    private FilterProvider getFiltersForUser() {

       SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("id","birthDate",
               "name","posts");
        return new SimpleFilterProvider()
                .addFilter("UserFilter", propertyFilter);

    }
}
