package data;

import excelParse.ExcelReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by alexandre on 12/02/2015.
 */
public class WorldData {
    String sheetName;
    private final Map<String, Country> countryByName = new HashMap<String, Country>();

    @Override
         public String toString() {
        return "WorldData{" +
                "sheetName='" + sheetName + '\'' +
                ", countryByName=" + countryByName +
                '}';
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public Map<String, Country> getCountryByName() {
        return countryByName;
    }

    public Country getCountryByName(String countryName) {
        return countryByName.get(countryName);
    }

    public void addCountry(Country country) {
        countryByName.put(country.getCountryName(), country);
    }

    public void addSheet(int sheetNumber, ExcelReader excelReader) {
        ArrayList<String> allCounrty = excelReader.getAllCountry();
        Country country = new Country();
        int i = 1;
        for (String countryName : allCounrty) {
            country.setCountryName(countryName);
            country.addCountry(excelReader.getCountry(i), excelReader.takeLineString(sheetNumber, i), excelReader.getAllYears());
            this.countryByName.put(countryName, country);
            i++;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(sheetName, countryByName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final WorldData other = (WorldData) obj;
        return Objects.equals(this.sheetName, other.sheetName)
                && Objects.equals(this.countryByName, other.countryByName);
    }
}
