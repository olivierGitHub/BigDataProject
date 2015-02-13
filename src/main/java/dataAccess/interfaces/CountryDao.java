package dataAccess.interfaces;

import model.Country;

import java.util.List;

/**
 * Created by Arnaud on 12/02/2015.
 */
public interface CountryDao extends Dao<Country> {

    public List<Country> getCountries();
}
