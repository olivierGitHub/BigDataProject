package bigdata.analytics.dto;

import bigdata.analytics.rate.CurrencyCode;

import java.util.Objects;

/**
 * Created by Arnaud on 18/02/2015.
 */
public class RateDto {
    CurrencyCode currencyCode;
    String year;
    double value;

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyCode, year, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final RateDto other = (RateDto) obj;
        return Objects.equals(this.currencyCode, other.currencyCode)
                && Objects.equals(this.year, other.year)
                && Objects.equals(this.value, other.value);
    }
}
