package ru.bellintegrator.practice.person.view;

import io.swagger.annotations.ApiModelProperty;

public class PersonView {

    @ApiModelProperty(hidden = true)
    public String id;

    public String name;

    public int age;

    /**
     * Нужен для десериализатора в jenkins
     */
    public PersonView() {

    }

    public PersonView(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";age" + age + "}";
    }
}