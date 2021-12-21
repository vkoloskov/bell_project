package ru.bellintegrator.practice.Document.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import ru.bellintegrator.practice.DocType.entity.DocType;
import ru.bellintegrator.practice.User.entity.User;

import javax.persistence.*;

/**
 * Документ
 */
@Entity(name = "Document")
@Getter
@Setter
public class Document {
    @Id
    @Column(name = "user_id")
    private Long userId;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Номер
     */
    @Column(name = "doc_number", length = 50, nullable = false)
    private String docNumber;

    /**
     * Дата
     */
    @Column(name = "doc_date", length = 50, nullable = false)
    private String docDate;


    /**
     * Пользователь
     */
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId
    private User user;


    /**
     * Тип документа
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_code")
    private DocType docType;

}
