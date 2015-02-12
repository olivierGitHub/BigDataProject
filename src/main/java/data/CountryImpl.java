package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexandre on 12/02/2015.
 */
public class CountryImpl implements Country {
    private String countryName;
    private final Map<String, String> tauxByYears = new HashMap<String, String>();

    @Override
    public String toString() {
        return "CountryImpl{" +
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

    @Override
    public void addCountry(String countryName, ArrayList<String> allValues, ArrayList<String> allYears) {
        setCountryName(countryName);
        int i = 0;
        for (String allValue : allValues) {
            tauxByYears.put(allYears.get(i),allValue);
            i++;
        }
    }

    @Override
    public Country getCountryInstance() {
        return this;
    }

    @Override
    public String getTaux(String year) {
        return tauxByYears.get(year);
    }
}
