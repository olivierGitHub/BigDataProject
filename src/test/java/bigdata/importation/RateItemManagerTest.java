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
        when(rateGroupAssembler.fromRateItem(any(RateItem.class))).thenCallRealMethod();
    }

    @Test
    public void testRateItemListToModel() throws Exception {
        List<RateItem> rateItemList = new ArrayList<RateItem>();
        RateKey rateKey = new RateKey("France", "2010", RateGroupType.EFFECTIVE);
        RateValue rateValue = new RateValue(1.12, "Euro");
        RateItem rateItem = new RateItem(rateKey, rateValue);
        rateItemList.add(rateItem);

        List<Country> modelExpected = new ArrayList<Country>();
        Country country = new Country("France");
        RateGroup rateGroup = new RateGroup();
        rateGroup.setCurrency(new CurrencyRate("Euro", CurrencyCode.Euro));
        rateGroup.setType(RateGroupType.EFFECTIVE);
        Rate rate = new Rate();
        rate.setYear("2010");
        rate.setValue(1.12);
        rateGroup.addRate(rate);
        country.addRateGroup(rateGroup);
        modelExpected.add(country);
        assertThat(rateItemManager.rateItemListToModel(rateItemList), is(modelExpected));
    }
}