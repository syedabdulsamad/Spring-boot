package com.example.HelloWorld.helloWorld;

public class HelloWorldBean {
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;
    public HelloWorldBean(String hello_world) {

        this.text = hello_world;
    }
}
