package bigdata.datastorage.dao.rate;

import bigdata.analytics.rate.Rate;
import bigdata.datastorage.impl.BaseJpa;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@Named
public class RateJpaDao extends BaseJpa implements RateDao {
    @Override
    public List<Rate> getRatesByYear(Integer rateGroupId, String year) {
        return null;
    }

    @Override
    public List<Rate> getRates(Integer rateGroupId) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("SELECT rate FROM Rate rate LEFT JOIN RateGroup rg ON rg.id = rate.id WHERE rate.id = :rateGroupId");
        query.setParameter("rateGroupId", rateGroupId);
        List<Rate> result = query.getResultList();
        return result;
    }

    @Override
    public void create(Rate obj) {
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
    public void update(Rate obj) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("UPDATE Rate rate SET rate = :obj WHERE rate.id = :obj.id");
        query.setParameter("obj", obj);
    }

    @Override
    public Rate read(int id) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("SELECT rate FROM Rate rate Where rate.id = :idRate");
        query.setParameter("idRate", id);
        Rate rateGroup = (Rate) query.getSingleResult();
        return rateGroup;
    }

    @Override
    public void delete(int id) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("DELETE FROM Rate rate Where rate.id = :idRate");
        query.setParameter("idRate", id);
    }
}
