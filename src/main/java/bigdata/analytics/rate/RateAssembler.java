package bigdata.analytics.rate;

import bigdata.importation.RateItem;

public class RateAssembler {

    public Rate fromRateItem(RateItem rateItem) {
        Rate rate = new Rate();
        rate.setYear(rateItem.getRateKey().getYear());
        rate.setValue(rateItem.getRateValue().getRate());
        return rate;
    }
}
