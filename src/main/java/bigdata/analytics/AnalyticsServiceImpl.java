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
public class AnalyticsServiceImpl implements AnalyticsService {
    /***
     * @param rateGroupType
     * @return List<RateGroup> en fonction de Param
     */

    @Override
    public List<CountryRateGroupDto> getRateGroupByType(RateGroupType rateGroupType, String year) {
        RateGroupDao dao = new RateGroupJpaDao();
        List<CountryRateGroupDto> rateGroupDtoList = new ArrayList<CountryRateGroupDto>();
        List<RateGroup> rateGroupList = dao.getRateGroupByRateGroupType(rateGroupType);

        String previousYear = Double.toString(Double.parseDouble(year) - 1);
        List<CountryRateGroupDto> countryRateGroupDtoList = new ArrayList<CountryRateGroupDto>();
        for (RateGroup eachRateGroup : rateGroupList) {
            createDtoForEachRateGroup(year, previousYear, countryRateGroupDtoList, eachRateGroup);
        }
        return rateGroupDtoList;
    }

    private void createDtoForEachRateGroup(String year, String previousYear, List<CountryRateGroupDto> countryRateGroupDtoList, RateGroup eachRateGroup) {
        CountryRateGroupDto dto = new CountryRateGroupDto(
                eachRateGroup.getCountry().getId(),
                eachRateGroup.getCountry().getCountryName(),
                eachRateGroup.getId()
        );
        for (Rate eachRate : eachRateGroup.getRates()) {
            createRateDtoForEachRate(year, previousYear, eachRateGroup, dto, eachRate);
        }
        countryRateGroupDtoList.add(dto);
    }

    private void createRateDtoForEachRate(String year, String previousYear, RateGroup eachRateGroup, CountryRateGroupDto dto, Rate eachRate) {
        if (eachRate.getYear().equals(year)) {
            dto.setSelectedYear(new RateDto(
                    eachRateGroup.getCurrency().getCurrencyCode(),
                    year,
                    eachRate.getValue()
            ));
        } else if (eachRate.getYear().equals(previousYear)) {
            dto.setPreviousSelectedYear(new RateDto(
                    eachRateGroup.getCurrency().getCurrencyCode(),
                    previousYear,
                    eachRate.getValue()
            ));
        }
    }
}