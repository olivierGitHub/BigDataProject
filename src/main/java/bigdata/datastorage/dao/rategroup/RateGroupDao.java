package bigdata.datastorage.dao.rategroup;

import bigdata.analytics.rategroup.RateGroup;
import bigdata.analytics.rategroup.RateGroupType;
import bigdata.datastorage.dao.Dao;

import java.util.List;

/**
 * Created by Arnaud on 13/02/2015.
 */
public interface RateGroupDao extends Dao<RateGroup> {

    public List<RateGroup> getRateGroupByRateGroupType(RateGroupType rateGroupType);
}
