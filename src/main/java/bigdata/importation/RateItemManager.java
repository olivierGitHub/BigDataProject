package bigdata.importation;

import bigdata.analytics.country.Country;
import bigdata.analytics.rate.Rate;
import bigdata.analytics.rate.RateAssembler;
import bigdata.analytics.rategroup.RateGroup;
import bigdata.analytics.rategroup.RateGroupAssembler;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Arnaud on 17/02/2015.
 */
public class RateItemManager {

    @Inject
    RateGroupAssembler rateGroupAssembler;
    @Inject
    RateAssembler rateAssembler;

    public List<Country> rateItemListToModel(List<RateItem> rateItemList) {
        List<Country> countryList = new ArrayList<Country>();
        Map<String, Country> countryMap = new HashMap<String, Country>();
        for (RateItem rateItem : rateItemList) {
            convertItemToCountryModel(rateGroupAssembler, rateAssembler, countryList, countryMap, rateItem);
        }
        return new ArrayList<Country>(countryMap.values());
    }

    private void convertItemToCountryModel(RateGroupAssembler rateGroupAssembler, RateAssembler rateAssembler, List<Country> countryList, Map<String, Country> countryMap, RateItem rateItem) {
        Country country = getCountryFromRateItemList(countryMap, rateItem);
        RateGroup rateGroup = rateGroupAssembler.fromRateItem(rateItem);
        Rate rate = rateAssembler.fromRateItem(rateItem);
        rateGroup.addRate(rate);
        country.addRateGroup(rateGroup);
        countryList.add(country);
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
