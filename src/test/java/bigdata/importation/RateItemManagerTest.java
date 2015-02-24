package bigdata.importation;

import bigdata.analytics.country.Country;
import bigdata.analytics.rate.CurrencyCode;
import bigdata.analytics.rate.CurrencyRate;
import bigdata.analytics.rate.Rate;
import bigdata.analytics.rate.RateAssembler;
import bigdata.analytics.rategroup.RateGroup;
import bigdata.analytics.rategroup.RateGroupAssembler;
import bigdata.analytics.rategroup.RateGroupType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RateItemManagerTest {

    @Mock
    RateGroupAssembler rateGroupAssembler;
    @Mock
    RateAssembler rateAssembler;

    @InjectMocks
    private RateItemManager rateItemManager = new RateItemManager();
    ;

    @Before
    public void setUp() throws Exception {
        when(rateAssembler.fromRateItem(any(RateItem.class))).thenCallRealMethod();
        when(rateGroupAssembler.fromRateItem(any(RateItem.class), any(RateGroup.class))).thenCallRealMethod();
        when(rateGroupAssembler.fromRateItem(any(RateItem.class))).thenCallRealMethod();
    }

    @Test
    public void testRateItemListToModel() throws Exception {
        List<RateItem> rateItemList = generateRateItemList();
        List<Country> modelExpected = generateModelExpected();
//        RateGroupJpaDao dao = new RateGroupJpaDao();
//        dao.getRateGroupByCriterias(RateGroupType.EFFECTIVE);
        assertThat(rateItemManager.rateItemListToModel(rateItemList), is(modelExpected));
    }

    private List<Country> generateModelExpected() {
        List<Country> modelExpected = new ArrayList<Country>();
        Country country;
        RateGroup rateGroup;
        Rate rate;

        country = createCountry("France");
        rateGroup = addNewRateGroupToCountry(
                country,
                createCurrencyRate("Euro", CurrencyCode.Euro),
                RateGroupType.EFFECTIVE
        );
        rate = addNewRateToRateGroup(rateGroup, "2010", rate(1.12));
        rate = addNewRateToRateGroup(rateGroup, "2009", rate(1.14));
        rateGroup = addNewRateGroupToCountry(
                country,
                createCurrencyRate("Euro", CurrencyCode.Euro),
                RateGroupType.NOMINATIVE
        );
        rate = addNewRateToRateGroup(rateGroup, "2010", rate(1.16));
        rate = addNewRateToRateGroup(rateGroup, "2008", rate(1.17));
        modelExpected.add(country);

        country = createCountry("Allemagne");
        rateGroup = addNewRateGroupToCountry(
                country,
                createCurrencyRate("Euro", CurrencyCode.Euro),
                RateGroupType.EFFECTIVE
        );
        rate = addNewRateToRateGroup(rateGroup, "2010", rate(1.13));
        modelExpected.add(country);

        country = createCountry("USA");
        rateGroup = addNewRateGroupToCountry(
                country,
                createCurrencyRate("Dollar", CurrencyCode.Dollar),
                RateGroupType.NOMINATIVE
        );
        rate = addNewRateToRateGroup(rateGroup, "2010", rate(1.15));
        modelExpected.add(country);

        return modelExpected;
    }

    private double rate(double rate) {
        return rate;
    }

    private Rate addNewRateToRateGroup(RateGroup rateGroup, String year, double rateValue) {
        Rate rate = new Rate();
        rate.setYear(year);
        rate.setValue(rateValue);
        rateGroup.addRate(rate);
        return rate;
    }

    private CurrencyRate createCurrencyRate(String currencyName, CurrencyCode currencyCode) {
        return new CurrencyRate(currencyName, currencyCode);
    }

    private RateGroup addNewRateGroupToCountry(Country country, CurrencyRate currencyRate, RateGroupType rateGroupType) {
        RateGroup rateGroup = new RateGroup();
        rateGroup.setCurrency(currencyRate);
        rateGroup.setType(rateGroupType);
        country.addRateGroup(rateGroup);
        return rateGroup;
    }

    private Country createCountry(String countryName) {
        return new Country(countryName);
    }

    private List<RateItem> generateRateItemList() {
        List<RateItem> rateItemList = new ArrayList<RateItem>();

        RateKey rateKey = new RateKey("France", "2010", RateGroupType.EFFECTIVE);
        RateValue rateValue = new RateValue(1.12, "Euro");
        RateItem rateItem = new RateItem(rateKey, rateValue);
        rateItemList.add(rateItem);

        rateKey = new RateKey("Allemagne", "2010", RateGroupType.EFFECTIVE);
        rateValue = new RateValue(1.13, "Euro");
        rateItem = new RateItem(rateKey, rateValue);
        rateItemList.add(rateItem);

        rateKey = new RateKey("France", "2009", RateGroupType.EFFECTIVE);
        rateValue = new RateValue(1.14, "Euro");
        rateItem = new RateItem(rateKey, rateValue);
        rateItemList.add(rateItem);

        rateKey = new RateKey("USA", "2010", RateGroupType.NOMINATIVE);
        rateValue = new RateValue(1.15, "Dollar");
        rateItem = new RateItem(rateKey, rateValue);
        rateItemList.add(rateItem);

        rateKey = new RateKey("France", "2010", RateGroupType.NOMINATIVE);
        rateValue = new RateValue(1.16, "Euro");
        rateItem = new RateItem(rateKey, rateValue);
        rateItemList.add(rateItem);

        rateKey = new RateKey("France", "2008", RateGroupType.NOMINATIVE);
        rateValue = new RateValue(1.17, "Euro");
        rateItem = new RateItem(rateKey, rateValue);
        rateItemList.add(rateItem);

        return rateItemList;
    }
}