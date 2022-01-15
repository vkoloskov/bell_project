package ru.bellintegrator.practice.Organization.entity;


import lombok.*;
import ru.bellintegrator.practice.Office.entity.Office;

import javax.persistence.*;
import java.util.Set;

/**
 * Офис
 */
@Entity(name = "Organization")
@Getter
@Setter
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
     * ИНН
     */
    @Column(name = "inn", length = 50, nullable = false)
    private String inn;

    /**
     * КПП
     */
    @Column(name = "kpp", length = 50, nullable = false)
    private String kpp;

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
