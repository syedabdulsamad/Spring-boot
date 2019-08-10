package com.example.HelloWorld.helloWorld.Controller;


import com.example.HelloWorld.helloWorld.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HellWorldController {

    @Autowired
    private MessageSource messageSource;



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

    @GetMapping(path = "/helloworld-internationlization")
    public String helloWorldInternationalization() {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }



}
