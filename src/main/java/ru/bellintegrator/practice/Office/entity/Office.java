package ru.bellintegrator.practice.Office.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.bellintegrator.practice.Organization.entity.Organization;
import ru.bellintegrator.practice.User.entity.User;

import javax.persistence.*;
import java.util.Set;

/**
 * Офис
 */
@Entity(name = "Office")
@Data
public class Office {

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
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     * Адрес
     */
    @Column(name = "address", length = 50, nullable = false)
    private String address;

    /**
     * Телефон
     */
    @Column(name = "phone", length = 50, nullable = false)
    private String phone;

    /**
     * Активный?
     */
    @Column(name = "is_active")
    private Boolean isActive;

    /**
     * Организация
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;


    /**
     * Пользователи
     */
    @OneToMany(mappedBy = "office", fetch = FetchType.LAZY)
    private Set<User> users;

    public void addUser(User user) {
        getUsers().add(user);
        user.setOffice(this);
    }

    public void removeUser(User user) {
        getUsers().remove(user);
        user.setOffice(null);
    }


}
