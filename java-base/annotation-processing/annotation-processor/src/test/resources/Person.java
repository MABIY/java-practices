package com.lh.test.annotationprocessor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.lh.annotation.AutoValueDTO;
import com.lh.annotation.Views;

/**
 *
 * @author lh
 */
@AutoValueDTO
public class Person extends B{

    @JsonView(value = Views.NEW.class)
    @JsonIgnore
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }
}

class B {
    private String b;
}

