package dataAccess.interfaces;

import model.Rate;
import model.RateType;

import java.util.List;

/**
 * Created by Arnaud on 13/02/2015.
 */
public interface RateDao extends Dao<Rate> {

    public List<Rate> getAllByType(RateType type);
}
