package bigdata.importation;

import java.util.Objects;

/**
 * Created by alexandre on 16/02/2015.
 */
public class RateItem {
    private RateKey rateKey;
    private RateValue rateValue;

    public RateItem(RateKey rateKey, RateValue rateValue) {
        this.rateKey = rateKey;
        this.rateValue = rateValue;
    }

    public RateKey getRateKey() {
        return rateKey;
    }

    public void setRateKey(RateKey rateKey) {
        this.rateKey = rateKey;
    }

    public RateValue getRateValue() {
        return rateValue;
    }

    public void setRateValue(RateValue rateValue) {
        this.rateValue = rateValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rateKey, rateValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final RateItem other = (RateItem) obj;
        return Objects.equals(this.rateKey, other.rateKey)
                && Objects.equals(this.rateValue, other.rateValue);
    }

    @Override
    public String toString() {
        return "RateItem{" +
                "rateKey=" + rateKey +
                ", rateValue=" + rateValue +
                '}';
    }
}
