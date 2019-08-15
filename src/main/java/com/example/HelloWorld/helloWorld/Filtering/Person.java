package com.example.HelloWorld.helloWorld.Filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("PersonFilter")
public class Person {


    private String name;
    private Integer age;
    private String profession;

    public Person(String name, Integer age, String profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
