package bigdata.analytics.dto;

import java.util.Objects;

public class CountryRateGroupDto {
    private String countryName;
    private int idCountry;
    private int rateGroupId;
    private RateDto selectedYear;
    private RateDto previousSelectedYear;

    public CountryRateGroupDto(int idCountry, String countryName, int rateGroupId) {
        this.idCountry = idCountry;
        this.countryName = countryName;
        this.rateGroupId = rateGroupId;
        selectedYear = RateDto.NULL_OBJECT;
        previousSelectedYear = RateDto.NULL_OBJECT;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public int getRateGroupId() {
        return rateGroupId;
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
