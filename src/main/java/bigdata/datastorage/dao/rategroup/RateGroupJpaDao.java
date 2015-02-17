package bigdata.datastorage.dao.rategroup;

import bigdata.analytics.rategroup.RateGroup;
import bigdata.analytics.rategroup.RateGroupType;
import bigdata.datastorage.impl.BaseJpa;

import java.util.List;

/**
 * Created by Arnaud on 13/02/2015.
 */
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
