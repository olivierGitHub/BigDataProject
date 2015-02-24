package bigdata.datastorage.dao.rategroup;

import bigdata.analytics.dto.CountryRateGroupDto;
import bigdata.analytics.rategroup.RateGroup;
import bigdata.analytics.rategroup.RateGroupType;
import bigdata.datastorage.impl.BaseJpa;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@Named
public class RateGroupJpaDao extends BaseJpa implements RateGroupDao {
    @Override
    public List<RateGroup> getRateGroupsByType(RateGroupType type) {
        //same as getRateGroupDtoByRateGroupType
        return null;
    }

    @Override
    public List<RateGroup> getRateGroupsByCountryAndType(Integer countryId, RateGroupType type) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("SELECT country.rateGroups FROM Country country, RateGroup rg WHERE country.id = :countryId AND rg.id = :type.id");
        query.setParameter("countryId", countryId);
        query.setParameter("type", type);
        List<RateGroup> result = query.getResultList();
        return null;
    }

    @Override
    public List<RateGroup> getRateGroups(Integer countryId) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("SELECT country.rateGroups FROM Country country WHERE country.id = :countryId");
        query.setParameter("countryId", countryId);
        List<RateGroup> result = query.getResultList();
        return result;
    }

    @Override
    public List<CountryRateGroupDto> getRateGroupDtoByRateGroupType(RateGroupType rateGroupType) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("SELECT rg.id, rg.country.countryName FROM RateGroup rg WHERE rg.type = :rateGroupType");
        query.setParameter("rateGroupType",rateGroupType);
        List<CountryRateGroupDto> result = query.getResultList();
        return result;
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
        EntityManager em = getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("UPDATE RateGroup rg SET rg = :obj WHERE rg.id = :obj.id");
        query.setParameter("obj", obj);
    }

    @Override
    public RateGroup read(int id) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("SELECT * FROM RateGroup rg Where rg.id = :idRateGroup");
        query.setParameter("idRateGroup", id);
        RateGroup rateGroup = (RateGroup) query.getSingleResult();
        return rateGroup;
    }

    @Override
    public void delete(int id) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("DELETE FROM RateGroup rg Where rg.id = :idRateGroup");
        query.setParameter("idRateGroup", id);
    }
}
