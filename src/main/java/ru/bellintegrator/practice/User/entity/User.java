package ru.bellintegrator.practice.User.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Пользователь
 */
@Entity(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Имя
     */
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    /**
     * Фамилия
     */
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    /**
     * Отчество
     */
    @Column(name = "middle_name", length = 50, nullable = false)
    private String middleName;

    /**
     * Телефон
     */
    @Column(name = "phone", length = 50, nullable = false)
    private String phone;

    /**
     * Адрес
     */
    @Column(name = "is_identified")
    private Boolean isIdentified;

    /**
     * Адрес
     */
    @Column(name = "address", length = 50, nullable = false)
    private String address;

    /**
     * Офис
     */
    //@OneToOne(optional = false, cascade = CascadeType.ALL)
    //@JoinColumn(name = "office_id")
    //private Office office;

    /**
     * Гражданство
     */
    //@OneToOne(optional = false, cascade = CascadeType.ALL)
    //@JoinColumn(name = "citizenship_code")
    //private Citizenship citizenship;

    /**
     * Документ
     */
    //@OneToOne(optional = false, cascade = CascadeType.ALL)
    //@JoinColumn(name = "document_id")
    //private Document document;


    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
