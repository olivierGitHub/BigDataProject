package bigdata.analytics.dto;

import java.util.Objects;

public class RateDto {

    public static final RateDto NULL_OBJECT = new RateDto(null, "0", 1d);
    String currency;
    String year;
    double value;

    public RateDto(String currencyCode, String year, double value) {
        this.currency = currencyCode;
        this.year = year;
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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
        return Objects.hash(currency, year, value);
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
        return Objects.equals(this.currency, other.currency)
                && Objects.equals(this.year, other.year)
                && Objects.equals(this.value, other.value);
    }
}
