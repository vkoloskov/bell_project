package ru.bellintegrator.practice.Organization.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import ru.bellintegrator.practice.Office.entity.Office;
import ru.bellintegrator.practice.User.entity.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Офис
 */
@Entity(name = "Organization")
@Data
public class Organization {

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
     * Название
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     * Полное название
     */
    @Column(name = "full_name", length = 50, nullable = false)
    private String fullName;

    /**
     * Офисы
     */
    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Office> offices;

    public void addOffice(Office office) {
        getOffices().add(office);
        office.setOrganization(this);
    }

    public void removeOffice(Office office) {
        getOffices().remove(office);
        office.setOrganization(null);
    }

}
