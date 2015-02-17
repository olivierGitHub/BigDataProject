package excelParse;

import java.util.Objects;

/**
 * Created by alexandre on 16/02/2015.
 */
public class RateKey {
    String country;
    String year;
    String rateGroupeType;

    public RateKey(String country, String year, String rateGroupeType) {
        this.country = country;
        this.year = year;
        this.rateGroupeType = rateGroupeType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRateGroupeType() {
        return rateGroupeType;
    }

    public void setRateGroupeType(String rateGroupeType) {
        this.rateGroupeType = rateGroupeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, year, rateGroupeType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final RateKey other = (RateKey) obj;
        return Objects.equals(this.country, other.country)
                && Objects.equals(this.year, other.year)
                && Objects.equals(this.rateGroupeType, other.rateGroupeType);
    }

    @Override
    public String toString() {
        return "RateKey{" +
                "country='" + country + '\'' +
                ", year='" + year + '\'' +
                ", rateGroupeType='" + rateGroupeType + '\'' +
                '}';
    }
}
