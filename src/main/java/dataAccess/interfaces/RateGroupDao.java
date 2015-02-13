package dataAccess.interfaces;

import model.RateGroup;
import model.RateGroupType;

import java.util.List;

/**
 * Created by Arnaud on 13/02/2015.
 */
public interface RateGroupDao extends Dao<RateGroup> {

    public List<RateGroup> getRateGroupsByType(RateGroupType type);

    public List<RateGroup> getRateGroupsByCountryAndType(Integer countryId, RateGroupType type);

    public List<RateGroup> getRateGroups(Integer countryId);
}
