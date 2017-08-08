package ru.bellintegrator.practice.model;

import javax.persistence.*;
import java.util.List;

/**
 * Дом
 */
@Entity(name = "House")
public class House {

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
     * Адрес
     */
    @Basic(optional = false)
    @Column(name = "address")
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "house", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Person> persons;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}