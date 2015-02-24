package bigdata.datastorage.dao.country;

import bigdata.analytics.country.Country;
import bigdata.datastorage.impl.BaseJpa;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@Named
public class CountryJpaDao extends BaseJpa implements CountryDao {


    @Override
    public void create(Country obj) {
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
    public void update(Country obj) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("UPDATE Country country SET country = :obj WHERE country.id = :obj.id");
        query.setParameter("obj", obj);
    }

    @Override
    public Country read(int id) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("SELECT country FROM Country country Where country.id = :idCountry");
        query.setParameter("idCountry", id);
        Country country = (Country) query.getSingleResult();
        return country;
    }

    @Override
    public void delete(int id) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("DELETE FROM Country country Where country.id = :idCountry");
        query.setParameter("idCountry", id);
    }

    @Override
    public List<Country> getCountries() {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("SELECT country FROM Country country");
        List<Country> result = query.getResultList();
        return result;
    }
}
