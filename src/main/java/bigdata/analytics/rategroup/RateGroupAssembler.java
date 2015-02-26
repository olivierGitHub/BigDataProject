package bigdata.analytics.rategroup;

import bigdata.importation.RateItem;

public class RateGroupAssembler {

    public RateGroup fromRateItem(RateItem rateItem, RateGroup rateGroup) {
        rateGroup.setType(rateItem.getRateKey().getRateGroupeType());
        rateGroup.setCurrency(rateItem.getRateValue().getCurrency());
        return rateGroup;
    }

    public RateGroup fromRateItem(RateItem rateItem) {
        RateGroup rateGroup = new RateGroup();
        rateGroup.setType(rateItem.getRateKey().getRateGroupeType());
        String currencyName = rateItem.getRateValue().getCurrency();
        rateGroup.setCurrency(currencyName);
        return rateGroup;
    }
}
