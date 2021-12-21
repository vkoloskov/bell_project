package ru.bellintegrator.practice.Citizenship.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import ru.bellintegrator.practice.Document.entity.Document;
import ru.bellintegrator.practice.User.entity.User;

import javax.persistence.*;
import java.util.Set;

/**
 * Гражданство
 */
@Entity(name = "Citizenship")
@Data
public class Citizenship {

    /**
     * Код
     */
    @Id
    @Column(name = "code", length = 50, nullable = false)
    private String code;

    /**
     * Имя
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

}
