package bigdata.datastorage.dao.rategroup;

import bigdata.analytics.dto.CountryRateGroupDto;
import bigdata.analytics.rategroup.RateGroup;
import bigdata.analytics.rategroup.RateGroupType;
import bigdata.datastorage.impl.BaseJpa;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Named
public class RateGroupJpaDao extends BaseJpa implements RateGroupDao {
    @Override
    public List<RateGroup> getRateGroupsByType(RateGroupType type) {
        return null;
    }

    @Override
    public List<RateGroup> getRateGroupsByCountryAndType(Integer countryId, RateGroupType type) {
        return null;
    }

    @Override
    public List<RateGroup> getRateGroups(Integer countryId) {
        return null;
    }

    @Override
    public List<CountryRateGroupDto> getRateGroupDtoByRateGroupType(RateGroupType rateGroupType) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        TypedQuery<CountryRateGroupDto> query = em.createQuery("SELECT c.countryName, c.id, rg.id FROM Country c JOIN RateGroup rg WHERE rg.type = :rateGroupType", CountryRateGroupDto.class);
        query.setParameter("rateGroupType",rateGroupType);
        List<CountryRateGroupDto> result = query.getResultList();
        return result;
    }

    @Override
    public void create(RateGroup obj) {

    }

    @Override
    public void update(RateGroup obj) {

    }

    @Override
    public RateGroup read(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
