package ru.bellintegrator.practice.Organization.dao;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.Organization.entity.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * {@inheritDoc}
 */
public interface OrganizationDao{


    /**
     * {@inheritDoc}
     */
    List<Organization> getAll(String name, String inn, Boolean isActive);

    /**
     * {@inheritDoc}
     */

    Organization loadById(Long id);

    /**
     * {@inheritDoc}
     */

    void save(Organization organization);
}
