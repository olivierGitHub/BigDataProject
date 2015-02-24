package bigdata.analytics;

import bigdata.analytics.dto.CountryRateGroupDto;
import bigdata.analytics.dto.RateDto;
import bigdata.analytics.rate.Rate;
import bigdata.analytics.rategroup.RateGroup;
import bigdata.analytics.rategroup.RateGroupType;
import bigdata.datastorage.dao.rategroup.RateGroupDao;
import bigdata.datastorage.dao.rategroup.RateGroupJpaDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandre on 18/02/2015.
 */
public class AnalyticsService {
    /***
     * @param rateGroupType
     * @return List<RateGroup> en fonction de Param
     */
    
    public List<CountryRateGroupDto> getRateGroupByType (RateGroupType rateGroupType, Integer countryId, String year){
        RateGroupDao dao = new RateGroupJpaDao();
        List<CountryRateGroupDto> rateGroupDtoList = new ArrayList<CountryRateGroupDto>();
        RateGroup rateGroup = dao.getRateGroupByCriterias(rateGroupType, countryId);
        String previousYear = Double.toString(Double.parseDouble(year) - 1);
        CountryRateGroupDto countryRateGroupDto = new CountryRateGroupDto();
        for (Rate eachRate : rateGroup.getRates()) {
            if(eachRate.getYear().equals(year)) {
                countryRateGroupDto.setSelectedYear(new RateDto(
                        rateGroup.getCurrency().getCurrencyCode(),
                        year,
                        eachRate.getValue()
                        ));
            }
        }

        return null;
    }
}