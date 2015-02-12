package data;

import excelParse.ExcelReader;

import java.util.Map;

/**
 * Created by alexandre on 12/02/2015.
 */
public interface WorldData {
    String toString();
    String getSheetName();
    void setSheetName(String sheetName);
    Map<String, Country> getCountryByName();
    Country getCountryByName(String countryName);
    void addCountry(Country country);
    void addSheet(int sheetNumber, ExcelReader excelReader);
}
