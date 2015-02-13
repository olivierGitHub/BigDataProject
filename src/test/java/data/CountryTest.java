package data;

import excelParse.ExcelReader;
import excelParse.ExcelReaderImpl;
import jxl.read.biff.BiffException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by alexandre on 12/02/2015.
 */
public class CountryTest {
    @Test
    public void shouldAddCountry(){
        Country country = new Country();
        try {
            ExcelReader excelReader = new ExcelReaderImpl("OCDE_file.xls");
            country.addCountry(excelReader.getCountry(1),excelReader.takeLineString(0,1),excelReader.getAllYears());
            String found = country.getCountryName();
            Map<String, String> foundMap = country.getTauxByYears();
            assertThat(found).isEqualTo("Australie");
            assertThat(foundMap).containsKey("2000");
            assertThat(foundMap).containsValue("5,0");
            assertThat(foundMap.get("2000")).isEqualTo("6,2");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
         public void shouldGetCountry(){
        Country country = new Country();
        try {
            ExcelReader excelReader = new ExcelReaderImpl("OCDE_file.xls");
            country.addCountry(excelReader.getCountry(1),excelReader.takeLineString(0,1),excelReader.getAllYears());
            String found = country.getCountryName();
            Map<String, String> foundMap = country.getTauxByYears();

            Country foundCountry = country.getCountryInstance();
            assertThat(foundCountry.getCountryName()).isEqualTo("Australie");
            assertThat(foundCountry.getTauxByYears()).containsKey("2000");
            assertThat(foundCountry.getTauxByYears()).containsValue("5,0");
            assertThat(foundCountry.getTauxByYears().get("2000")).isEqualTo("6,2");

            String foundTaux = country.getTaux("2000");
            assertThat(foundTaux).isEqualTo("6,2");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }
}
