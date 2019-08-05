package com.example.HelloWorld.helloWorld.Controller;


import com.example.HelloWorld.helloWorld.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellWorldController {



    @GetMapping(path = "/helloworld")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/helloworld-bean")
    public HelloWorldBean helloWorldBean() {
        return  new HelloWorldBean("Hello World");
    }


    @GetMapping(path = "/helloworld-bean/path/{name}")
    public HelloWorldBean helloWorldBeanPath(@PathVariable String name) {

        return  new HelloWorldBean("Hello World, " + name);
    }



}
