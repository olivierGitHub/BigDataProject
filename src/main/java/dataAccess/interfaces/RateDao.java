package dataAccess.interfaces;

import model.Rate;

import java.util.List;

/**
 * Created by Arnaud on 13/02/2015.
 */
public interface RateDao extends Dao<Rate> {

    public List<Rate> getRatesByYear(Integer rateGroupId, String year);

    public List<Rate> getRates(Integer rateGroupId);

}
