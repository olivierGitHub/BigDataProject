package bigdata.importation;

import bigdata.analytics.rategroup.RateGroupType;

import java.util.Objects;

/**
 * Created by alexandre on 16/02/2015.
 */
public class RateKey {
    String countryName;
    String year;
    RateGroupType rateGroupeType;

    public RateKey(String country, String year, RateGroupType rateGroupeType) {
        this.countryName = country;
        this.year = year;
        this.rateGroupeType = rateGroupeType;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public RateGroupType getRateGroupeType() {
        return rateGroupeType;
    }

    public void setRateGroupeType(RateGroupType rateGroupeType) {
        this.rateGroupeType = rateGroupeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryName, year, rateGroupeType);
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
        return Objects.equals(this.countryName, other.countryName)
                && Objects.equals(this.year, other.year)
                && Objects.equals(this.rateGroupeType, other.rateGroupeType);
    }

    @Override
    public String toString() {
        return "RateKey{" +
                "countryName='" + countryName + '\'' +
                ", year='" + year + '\'' +
                ", rateGroupeType='" + rateGroupeType + '\'' +
                '}';
    }
}
