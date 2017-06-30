package ru.bellintegrator.practice.model;

import javax.persistence.*;

/**
 * Dummy data model.
 * Just for test
 */
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Иия
     */
    @Basic(optional = false)
    @Column(name = "first_name")
    private String name;

    /**
     * Возраст
     * т.к. поле примитивного типа, оно не может быть nullable
     */
    @Basic(optional = false)
    @Column(name = "age")
    private int age;

    // для hibernate
    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "{id:" + getId() + ";name:" + getName() + ";age" + getAge() + "}";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
