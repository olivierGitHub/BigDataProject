package bigdata.analytics;

import bigdata.analytics.rategroup.RateGroup;
import bigdata.analytics.rategroup.RateGroupType;
import bigdata.datastorage.dao.rategroup.RateGroupDao;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by alexandre on 18/02/2015.
 */
public class AnalyticsService {
    @Inject
    RateGroupDao rateGroupDao;
    /***
     * @param rateGroupType
     * @return List<RateGroup> en fonction de Param
     */
    
    public List<RateGroup> getRateGroupByType (RateGroupType rateGroupType){
        return rateGroupDao.getRateGroupsByType(rateGroupType);
    }
}