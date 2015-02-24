package bigdata.datastorage.dao.rategroup;

import bigdata.analytics.rategroup.RateGroup;
import bigdata.analytics.rategroup.RateGroupType;
import bigdata.datastorage.impl.BaseJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class RateGroupJpaDao extends BaseJpa implements RateGroupDao {

    public RateGroupJpaDao() {
    }

    @Override
    public RateGroup getRateGroupByCriterias(RateGroupType rateGroupType, Integer countryId) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        TypedQuery<RateGroup> query = em.createQuery("select rg from RateGroup rg where rg.country.id = :countryId and rg.type = :type", RateGroup.class);
        query.setParameter("countryId", countryId);
        query.setParameter("type", rateGroupType);
        List<RateGroup> resultList = query.getResultList();
        if(resultList == null || resultList.size() > 1) return null;
        else return resultList.get(0);
    }

    @Override
    public void create(RateGroup obj) {
        EntityManager em = super.getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.persist(obj);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (t.isActive()) {
                t.rollback();
                em.close();
            }
        }
    }

    @Override
    public void update(RateGroup obj) {
        EntityManager em = super.getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.merge(obj);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (t.isActive()) {
                t.rollback();
                em.close();
            }
        }
    }

    @Override
    public RateGroup read(int id) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        return em.find(RateGroup.class, id);
    }

    @Override
    public void delete(int id) {
        EntityManager em = super.getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.remove(read(id));
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (t.isActive()) {
                t.rollback();
                em.close();
            }
        }
    }
}
