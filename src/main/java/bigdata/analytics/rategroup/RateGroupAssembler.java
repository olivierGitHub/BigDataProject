package bigdata.analytics.rategroup;

import bigdata.analytics.rate.CurrencyCode;
import bigdata.analytics.rate.CurrencyRate;
import bigdata.importation.RateItem;

public class RateGroupAssembler {

    public RateGroup fromRateItem(RateItem rateItem, RateGroup rateGroup) {
        rateGroup.setType(rateItem.getRateKey().getRateGroupeType());
        String currencyName = rateItem.getRateValue().getCurrency();
        rateGroup.setCurrency(new CurrencyRate(currencyName, CurrencyCode.valueOf(currencyName)));
        return rateGroup;
    }

    public RateGroup fromRateItem(RateItem rateItem) {
        RateGroup rateGroup = new RateGroup();
        rateGroup.setType(rateItem.getRateKey().getRateGroupeType());
        String currencyName = rateItem.getRateValue().getCurrency();
        rateGroup.setCurrency(new CurrencyRate(currencyName, CurrencyCode.valueOf(currencyName)));
        return rateGroup;
    }
}
