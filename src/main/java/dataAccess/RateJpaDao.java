package dataAccess;

import dataAccess.interfaces.RateDao;
import model.Rate;

import java.util.List;

/**
 * Created by Arnaud on 13/02/2015.
 */
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
