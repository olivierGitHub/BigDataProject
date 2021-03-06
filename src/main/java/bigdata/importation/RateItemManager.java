package bigdata.importation;

import bigdata.analytics.country.Country;
import bigdata.analytics.rate.Rate;
import bigdata.analytics.rate.RateAssembler;
import bigdata.analytics.rategroup.RateGroup;
import bigdata.analytics.rategroup.RateGroupAssembler;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Arnaud on 17/02/2015.
 */
public class RateItemManager {

    RateGroupAssembler rateGroupAssembler = new RateGroupAssembler();
    RateAssembler rateAssembler = new RateAssembler();

    public List<Country> rateItemListToModel(List<RateItem> rateItemList) {
        List<Country> countryList = new ArrayList<Country>();
        Map<String, Country> countryMap = new LinkedHashMap<String, Country>();
        for (RateItem rateItem : rateItemList) {
            convertItemToCountryModel(countryList, countryMap, rateItem);
        }
        return new ArrayList<Country>(countryMap.values());
    }

    private void convertItemToCountryModel(List<Country> countryList, Map<String, Country> countryMap, RateItem rateItem) {
        Country country = getCountryFromRateItemList(countryMap, rateItem);
        RateGroup rateGroup = getRateGroupFromRateItemListByType(countryMap, rateItem, country);
        Rate rate = rateAssembler.fromRateItem(rateItem);
        rate.setRateGroup(rateGroup);
        rateGroup.addRate(rate);
        rateGroup.setCountry(country);
        countryList.add(country);
    }

    private RateGroup getRateGroupFromRateItemListByType(Map<String, Country> countryMap, RateItem rateItem, Country country) {
        for (RateGroup rateGroup : countryMap.get(rateItem.getRateKey().getCountryName()).getRateGroups()) {
            if (rateGroup.getType().equals(rateItem.getRateKey().getRateGroupeType())) {
                rateGroup = rateGroupAssembler.fromRateItem(rateItem, rateGroup);
                return rateGroup;
            }
        }
        RateGroup newRateGroup = rateGroupAssembler.fromRateItem(rateItem);
        country.addRateGroup(newRateGroup);
        return newRateGroup;
    }

    private Country getCountryFromRateItemList(Map<String, Country> countryMap, RateItem rateItem) {
        Country country = countryMap.get(rateItem.getRateKey().getCountryName());
        if (country == null) {
            country = new Country(rateItem.getRateKey().getCountryName());
            countryMap.put(country.getCountryName(), country);
        }
        return country;
    }
}
