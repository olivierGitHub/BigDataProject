package bigdata.analytics;

import bigdata.analytics.dto.CountryRateGroupDto;
import bigdata.analytics.rategroup.RateGroupType;

import java.util.List;

/**
 * Created by Arnaud on 25/02/2015.
 */
public interface AnalyticsService {


    List<CountryRateGroupDto> getRateGroupByType(RateGroupType rateGroupType, String year);
}
