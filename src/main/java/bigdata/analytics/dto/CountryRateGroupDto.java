package bigdata.analytics.dto;

import java.util.Objects;

/**
 * Created by Arnaud on 18/02/2015.
 */
public class CountryRateGroupDto {
    String countryName;
    int idCountry;
    int rateGroupId;
    RateDto selectedYear;
    RateDto previousSelectedYear;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public int getRateGroupId() {
        return rateGroupId;
    }

    public void setRateGroupId(int rateGroupId) {
        this.rateGroupId = rateGroupId;
    }

    public RateDto getSelectedYear() {
        return selectedYear;
    }

    public void setSelectedYear(RateDto selectedYear) {
        this.selectedYear = selectedYear;
    }

    public RateDto getPreviousSelectedYear() {
        return previousSelectedYear;
    }

    public void setPreviousSelectedYear(RateDto previousSelectedYear) {
        this.previousSelectedYear = previousSelectedYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryName, idCountry, rateGroupId, selectedYear, previousSelectedYear);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final CountryRateGroupDto other = (CountryRateGroupDto) obj;
        return Objects.equals(this.countryName, other.countryName)
                && Objects.equals(this.idCountry, other.idCountry)
                && Objects.equals(this.rateGroupId, other.rateGroupId)
                && Objects.equals(this.selectedYear, other.selectedYear)
                && Objects.equals(this.previousSelectedYear, other.previousSelectedYear);
    }
}
