package ru.bellintegrator.practice.Citizenship.entity;

import lombok.Data;
import javax.persistence.*;

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
