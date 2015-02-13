package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by alexandre on 12/02/2015.
 */
public class Country {
    private String countryName;
    private final Map<String, String> tauxByYears = new HashMap<String, String>();

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", tauxByYears=" + tauxByYears +
                '}';
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Map<String, String> getTauxByYears() {
        return tauxByYears;
    }

    public void addCountry(String countryName, ArrayList<String> allValues, ArrayList<String> allYears) {
        setCountryName(countryName);
        int i = 0;
        for (String allValue : allValues) {
            tauxByYears.put(allYears.get(i),allValue);
            i++;
        }
    }

    public Country getCountryInstance() {
        return this;
    }

    public String getTaux(String year) {
        return tauxByYears.get(year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryName, tauxByYears);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Country other = (Country) obj;
        return Objects.equals(this.countryName, other.countryName)
                && Objects.equals(this.tauxByYears, other.tauxByYears);
    }
}
