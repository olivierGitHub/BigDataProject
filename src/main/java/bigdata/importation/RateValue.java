package bigdata.importation;

import java.util.Objects;

/**
 * Created by alexandre on 16/02/2015.
 */
public class RateValue {
    private Double rate;
    private String currencyName;

    public RateValue(Double taux, String currency) {
        this.rate = taux;
        this.currencyName = currency;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getCurrency() {
        return currencyName;
    }

    public void setCurrency(String currency) {
        this.currencyName = currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate, currencyName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final RateValue other = (RateValue) obj;
        return Objects.equals(this.rate, other.rate)
                && Objects.equals(this.currencyName, other.currencyName);
    }

    @Override
    public String toString() {
        return "RateValue{" +
                "rate=" + rate +
                ", currencyName='" + currencyName + '\'' +
                '}';
    }
}
