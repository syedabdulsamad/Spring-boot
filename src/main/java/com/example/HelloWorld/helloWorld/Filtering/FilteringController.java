package com.example.HelloWorld.helloWorld.Filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilteringController {


    @GetMapping("/one-person")
    public MappingJacksonValue getPerson() {
        Person person = new Person("Abdul",22,"developer");
        MappingJacksonValue mappig = new MappingJacksonValue(person);
        SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("name");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("PersonFilter", propertyFilter);
        mappig.setFilters(filterProvider);
        return mappig;
    }


    @GetMapping("/persons")
    public MappingJacksonValue getPersons() {

        List<Person> persons = new ArrayList();
        persons.add(new Person("Abdul",22,"developer"));
        persons.add(new Person("Syed Samad",25,"Engineer"));
        MappingJacksonValue mappig = new MappingJacksonValue(persons);
        mappig.setFilters(getFilter());
        return mappig;
    }

    private FilterProvider getFilter() {

        SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("name");
        return new SimpleFilterProvider().addFilter("PersonFilter", propertyFilter);

    }
}
