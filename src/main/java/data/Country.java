package data;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by alexandre on 12/02/2015.
 */
public interface Country {
    String toString();
    String getCountryName();
    void setCountryName(String countryName);
    Map<String, String> getTauxByYears();

    void addCountry(String countryName, ArrayList<String> allValues, ArrayList<String> allYears);

    Country getCountryInstance();

    String getTaux(String year);
}
