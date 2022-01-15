package ru.bellintegrator.practice.Organization.dao;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.Office.dao.OfficeDao;
import ru.bellintegrator.practice.Office.entity.Office;
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
@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Builder
    public List<Organization> getAll(String name, String inn, Boolean isActive) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Organization> cq = cb.createQuery(Organization.class);
        Root<Organization> organizationRoot = cq.from(Organization.class);

        cq.select(organizationRoot);

        Predicate namePredicate = cb.equal(organizationRoot.get("name"), name);
        Predicate finalPredicate = cb.and(namePredicate);

        if(inn != null) {
            Predicate activePredicate = cb.equal(organizationRoot.get("inn"), inn );
            finalPredicate = cb.and(activePredicate);
        }

        if(isActive != null) {
            Predicate activePredicate = cb.equal(organizationRoot.get("inn"), isActive );
            finalPredicate = cb.and(activePredicate);
        }
        cq.where(finalPredicate);

        TypedQuery<Organization> q = em.createQuery(cq);
        return q.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization loadById(Long id) {
        Organization organization = em.find(Organization.class,id);
        return organization;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Organization organization) {
        em.persist(organization);
    }

//    @Override
//    public void update(Office office) {
//        Office tmpOffice = loadById(office.getId());
//        tmpOffice.setName(office.getName());
//        tmpOffice.setAddress(office.getAddress());
//        tmpOffice.setIsActive(office.getIsActive());
//        save(tmpOffice);
//    }
}
