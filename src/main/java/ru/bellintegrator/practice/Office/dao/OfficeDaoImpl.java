package ru.bellintegrator.practice.Office.dao;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.Office.entity.Office;
import ru.bellintegrator.practice.Office.filter.OfficeFilter;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Collection;
import java.util.List;
/**
 * {@inheritDoc}
 */
@Repository
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Builder
    public List<Office> getAll(Of) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Office> cq = cb.createQuery(Office.class);
        Root<Office> officeRoot = cq.from(Office.class
);
        cq.select(officeRoot);
        Predicate orgIdPredicate = cb.equal(officeRoot.get("organization").get("id"),filter.getIdOrg());
        Predicate finalPredicate = cb.and(orgIdPredicate);
        if(filter.getName() != null) {
            Predicate namePredicate = cb.equal(officeRoot.get("name"), filter.getName());
            finalPredicate = cb.and(namePredicate);
        }
        if(filter.getActive() != null) {
            Predicate activePredicate = cb.equal(officeRoot.get("isActive"), filter.getActive());
            finalPredicate = cb.and(activePredicate);
        }
        cq.where(finalPredicate);

        TypedQuery<Office> q = em.createQuery(cq);
        return q.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Office loadById(Long id) {
        Office office = em.find(Office.class,id);
        return office;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Office office) {
        em.persist(office);
    }

//    @Override
//    public Office update(Office office) {
//        Office tmpOffice = loadById(office.getId());
//        tmpOffice.setName(office.getName());
//        tmpOffice.setAddress(office.getAddress());
//        tmpOffice.setIsActive(office.getIsActive());
//        save(tmpOffice);
//    }

}
