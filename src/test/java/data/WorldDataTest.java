package data;

import excelParse.ExcelReader;
import excelParse.ExcelReaderImpl;
import jxl.read.biff.BiffException;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by alexandre on 12/02/2015.
 */
public class WorldDataTest {
    @Test
    public void shouldAddCountryToWorldData(){
        ExcelReader excelReader = null;
        try {
            excelReader = new ExcelReaderImpl("OCDE_file.xls");
            WorldData world = new WorldData();
            
            Country australie = new Country();
            australie.addCountry(excelReader.getCountry(1),excelReader.takeLineString(0,1),excelReader.getAllYears());
            world.addCountry(australie);
            
            Country irlande = new Country();
            irlande.addCountry(excelReader.getCountry(15),excelReader.takeLineString(0,15),excelReader.getAllYears());
            world.addCountry(irlande);

            assertThat(world.getCountryByName().get("Australie")).isEqualTo(australie);
            assertThat(world.getCountryByName().get("Irlande")).isEqualTo(irlande);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldGetCountryToWorldData(){
        ExcelReader excelReader = null;
        try {
            excelReader = new ExcelReaderImpl("OCDE_file.xls");
            WorldData world = new WorldData();
            world.setSheetName(excelReader.getNameSheet(0));
            
            Country australie = new Country();
            australie.addCountry(excelReader.getCountry(1),excelReader.takeLineString(0,1),excelReader.getAllYears());
            world.addCountry(australie);

            Country irlande = new Country();
            irlande.addCountry(excelReader.getCountry(15),excelReader.takeLineString(0,15),excelReader.getAllYears());
            world.addCountry(irlande);
            
            assertThat(world.getSheetName()).isEqualTo("TauxInteretCourtTerme");
            assertThat(world.getCountryByName("Australie")).isEqualTo(australie);
            assertThat(world.getCountryByName("Irlande")).isEqualTo(irlande);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldGetAllCountryFromAExcelSheetToWorldData(){
        ExcelReader excelReader = null;
        try {
            excelReader = new ExcelReaderImpl("OCDE_file.xls");
            WorldData world = new WorldData();
            world.addSheet(0, excelReader);
            
            Country australie = new Country();
            australie.setCountryName("Australie");
            australie.addCountry(excelReader.getCountry(1),excelReader.takeLineString(0,1),excelReader.getAllYears());

            Country irlande = new Country();
            irlande.addCountry(excelReader.getCountry(15),excelReader.takeLineString(0,15),excelReader.getAllYears());

            assertThat(world.getCountryByName("Australie")).isEqualTo(australie);
            assertThat(world.getCountryByName("Irlande")).isEqualTo(irlande);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }
}
