package bigdata.datastorage.dao.rate;

import bigdata.analytics.rate.Rate;
import bigdata.datastorage.impl.BaseJpa;

import javax.inject.Named;
import java.util.List;

@Named
public class RateJpaDao extends BaseJpa implements RateDao {
    @Override
    public List<Rate> getRatesByYear(Integer rateGroupId, String year) {
        return null;
    }

    @Override
    public List<Rate> getRates(Integer rateGroupId) {
        return null;
    }

    @Override
    public void create(Rate obj) {

    }

    @Override
    public void update(Rate obj) {

    }

    @Override
    public Rate read(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
