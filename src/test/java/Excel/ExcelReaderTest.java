package Excel;

import excelParse.ExcelReader;
import excelParse.ExcelReaderImpl;
import jxl.read.biff.BiffException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by alexandre on 05/02/2015.
 * */


public class ExcelReaderTest {

    @Test
    public void shouldTakeWorkbook(){
        try {
            ExcelReader excelReader = new ExcelReaderImpl("Nofile.xls");
            assertThat(false).isTrue();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            assertThat(true).isTrue();
            e.printStackTrace();
        }
    }


    @Test
    public void shouldTakeALineWithSheetAndRowInString(){
        try {
            ExcelReader excelReader = new ExcelReaderImpl("OCDE_file.xls");
            Collection<String> ligne = new ArrayList<String>();
            ligne = excelReader.takeLineString(0, 1);
            assertThat(ligne).containsOnly("5,0","6,2","4,9","4,7","4,9","5,5","5,6","6,0","6,7","7,0","3,4","4,7","4,8","3,7","2,7","2,4","2,5");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeALineWithSheetAndRowInStringWithoutNull(){
        try {
            ExcelReader excelReader = new ExcelReaderImpl("OCDE_file.xls");
            Collection<String> ligne = new ArrayList<String>();
            ligne = excelReader.takeLineString(0, 2);
            assertThat(ligne).containsOnly("...");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeALineWithSheetAndRowInDouble(){
        try {
            ExcelReader excelReader = new ExcelReaderImpl("OCDE_file.xls");
            Collection<Double> ligne = new ArrayList<Double>();
            ligne = excelReader.takeLineDouble(0,1);
            assertThat(ligne).contains(5.0,6.2,4.9,4.7,4.9,5.5,5.6,6.0,6.7,2.4,2.5);
            assertThat(ligne).doesNotContain(-1.0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeCountryFromFirstSheet(){
        try {
            ExcelReader excelReader = new ExcelReaderImpl("OCDE_file.xls");
            Collection<String> country = new ArrayList<String>();
            country = excelReader.getAllCountry();
            assertThat(country).contains("Australie", "Autriche", "Belgique", "Etats-Unis");
            assertThat(country).doesNotContain("");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeYearsFromFirstSheet(){
        try {
            ExcelReader excelReader = new ExcelReaderImpl("OCDE_file.xls");
            Collection<String> years = new ArrayList<String>();
            years = excelReader.getAllYears();
            assertThat(years).contains("1999","2000","2002","2015");
            assertThat(years).doesNotContain("");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeNumberOfLineForSheet(){
        try {
            ExcelReader excelReader = new ExcelReaderImpl("OCDE_file.xls");
            int allLine;
            allLine = excelReader.takeNumberOfLine(0);
            assertThat(allLine).isEqualTo(34);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeAllLineFromASheetInString(){
        try {
            ExcelReader excelReader = new ExcelReaderImpl("OCDE_file.xls");
            Collection<ArrayList<String>> allLine = new ArrayList<ArrayList<String>>();
            allLine = excelReader.takeAllLineString(0);
            for (ArrayList<String> collect : allLine) {
                System.out.println("collect = " + collect);
                assertThat(collect).doesNotContain("");
            }
            assertThat(allLine.size()).isEqualTo(34);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeAllSheetLineInString() {
        try {
            ExcelReader excelReader = new ExcelReaderImpl("OCDE_file.xls");
            Collection<ArrayList<ArrayList<String>>> allSheetLine = new ArrayList<ArrayList<ArrayList<String>>>();
            allSheetLine = excelReader.takeAllSheetLineString();
            for (ArrayList<ArrayList<String>> sheetLists : allSheetLine) {
                System.out.println("NewSheet!");
                for (ArrayList<String> LineList : sheetLists) {
                    System.out.println("LineList = " + LineList);
                    assertThat(LineList).doesNotContain("");
                }
            }
            assertThat(allSheetLine.size()).isEqualTo(4);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeAllLineFromASheetInDouble(){
        try {
            ExcelReader excelReader = new ExcelReaderImpl("OCDE_file.xls");
            Collection<ArrayList<Double>> allLine = new ArrayList<ArrayList<Double>>();
            allLine = excelReader.takeAllLineDouble(0);
            for (ArrayList<Double> collect : allLine) {
                System.out.println("collect = " + collect);
            }
            assertThat(allLine.size()).isEqualTo(34);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeAllSheetLineInDouble() {
        try {
            ExcelReader excelReader = new ExcelReaderImpl("OCDE_file.xls");
            Collection<ArrayList<ArrayList<Double>>> allSheetLine = new ArrayList<ArrayList<ArrayList<Double>>>();
            allSheetLine = excelReader.takeAllSheetLineDouble();
            for (ArrayList<ArrayList<Double>> sheetLists : allSheetLine) {
                System.out.println("NewSheet!");
                for (ArrayList<Double> LineList : sheetLists) {
                    System.out.println("LineList = " + LineList);
                }
                assertThat(sheetLists.size()).isEqualTo(34);
            }
            assertThat(allSheetLine.size()).isEqualTo(4);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldGetCountryForACell(){
        try {
            ExcelReader excelReader = new ExcelReaderImpl("OCDE_file.xls");
            int x =1,y=1;
            String countryFound = excelReader.getCountry(y);
            assertThat(countryFound).isEqualTo("Australie");
            x =2; y=5;
            String countryFound2 = excelReader.getCountry(y);
            assertThat(countryFound2).isEqualTo("Chili");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldGetYearForACell(){
        try {
            ExcelReader excelReader = new ExcelReaderImpl("OCDE_file.xls");
            int x =1,y=1;
            String yearFound = excelReader.getYear(x);
            assertThat(yearFound).isEqualTo("1999");
            x =2; y=5;
            String yearFound2 = excelReader.getYear(x);
            assertThat(yearFound2).isEqualTo("2000");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldGetAllNameSheet(){
        try {
            Collection<String> allNameSheet = new ArrayList<String>();
            ExcelReader excelReader = new ExcelReaderImpl("OCDE_file.xls");
            allNameSheet = excelReader.getAllNameSheet();
            assertThat(allNameSheet).containsOnly("TauxInteretCourtTerme","TauxInteretLongTerme","TauxChangeNominaux","TauxChangeEffectifs");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldGetNameSheet(){
        try {
            ExcelReader excelReader = new ExcelReaderImpl("OCDE_file.xls");
            String found = excelReader.getNameSheet(0);
            assertThat(found).isEqualTo("TauxInteretCourtTerme");
            String found2 = excelReader.getNameSheet(2);
            assertThat(found2).isEqualTo("TauxChangeNominaux");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

/*    @Test
    public void shouldGetAUniteMonetaire(){
        try {
            ExcelReader excelReader = new ExcelReaderImpl("OCDE_file.xls");
            String found = excelReader.getUniteMonetaire(2);
            assertThat(found).isEqualTo("Dollar");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }*/
}
