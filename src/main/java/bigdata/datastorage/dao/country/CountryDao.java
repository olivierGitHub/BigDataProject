package bigdata.datastorage.dao.country;

import bigdata.analytics.country.Country;
import bigdata.datastorage.dao.Dao;

import java.util.List;

/**
 * Created by Arnaud on 12/02/2015.
 */
public interface CountryDao extends Dao<Country> {

    public List<Country> getCountries();
}
