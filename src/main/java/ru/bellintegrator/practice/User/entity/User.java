package ru.bellintegrator.practice.User.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import ru.bellintegrator.practice.Citizenship.entity.Citizenship;
import ru.bellintegrator.practice.Document.entity.Document;
import ru.bellintegrator.practice.Office.entity.Office;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Пользователь
 */
@Entity(name = "User")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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
     * Идентефицирован
     */
    @Column(name = "is_identified")
    private Boolean isIdentified;


    /**
     * Офис
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "office_id")
    private Office office;

    /**
     * Гражданство
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "citizenship_code")
    private Citizenship citizenship;

    /**
     * Документ
     */
    @OneToOne(optional = false, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Document document;

}
