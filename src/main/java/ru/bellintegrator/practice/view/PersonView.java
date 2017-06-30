package ru.bellintegrator.practice.view;

/**
 * Dummy data view
 * Just for test
 */
public class PersonView {
    public String id;

    public String name;

    public int age;

    //для jackson
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