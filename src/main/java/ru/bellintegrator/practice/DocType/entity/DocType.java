package ru.bellintegrator.practice.DocType.entity;

import lombok.Data;
import javax.persistence.*;

/**
 * Тип документа
 */
@Entity(name = "Doc_Type")
@Data
public class DocType {

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
