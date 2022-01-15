package ru.bellintegrator.practice.Office.dao;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.Office.entity.Office;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
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
    public List<Office> getAll(Long orgId, String name, Boolean isActive) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Office> cq = cb.createQuery(Office.class);
        Root<Office> officeRoot = cq.from(Office.class);

        cq.select(officeRoot);
        Predicate orgIdPredicate = cb.equal(officeRoot.get("organization").get("id"),orgId);
        Predicate finalPredicate = cb.and(orgIdPredicate);
        if(name != null) {
            Predicate namePredicate = cb.equal(officeRoot.get("name"), name);
            finalPredicate = cb.and(namePredicate);
        }
        if(isActive != null) {
            Predicate activePredicate = cb.equal(officeRoot.get("isActive"), isActive );
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
//    public void update(Office office) {
//        Office tmpOffice = loadById(office.getId());
//        tmpOffice.setName(office.getName());
//        tmpOffice.setAddress(office.getAddress());
//        tmpOffice.setIsActive(office.getIsActive());
//        save(tmpOffice);
//    }
}
