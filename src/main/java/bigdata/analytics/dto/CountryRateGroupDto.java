package bigdata.analytics.dto;

import javax.persistence.*;
import java.util.Objects;

@SqlResultSetMapping(name="carkey",
        entities=@EntityResult(entityClass=CountryRateGroupDto.class,
                fields = {
                        @FieldResult(name="idCountry", column = "country_id"),
                        @FieldResult(name="countryName", column = "country_name"),
                        @FieldResult(name="rateGroupId", column = "rate_group_id")
                }))

public class CountryRateGroupDto {
    private String countryName;
    private int idCountry;
    private int rateGroupId;
    private RateDto selectedYear;
    private RateDto previousSelectedYear;

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
