package excelParse;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by alco on 09/02/2015.
 */
public class ExcelReaderImpl implements ExcelReader{
    Workbook workbook;

    public ExcelReaderImpl(String workbook) throws IOException,BiffException{
        this.workbook = Workbook.getWorkbook(new File(workbook));
    }

    @Override
    public Collection<String> takeLineString(int sheetNumber, int rowNumber) throws IllegalArgumentException{
        Collection<String> ligne = new ArrayList<String>();
        int numberOfSheets = workbook.getNumberOfSheets();
        String contentValue = null;
        if (sheetNumber >= numberOfSheets || sheetNumber < 0){
            throw new IllegalArgumentException("sheetNumber is not correct!");
        }
        Sheet sheet = workbook.getSheet(sheetNumber);

        int x = 1;
        do{
            contentValue = sheet.getCell(x, rowNumber).getContents();
            ligne.add(contentValue.trim());
            x++;
        }while (!sheet.getCell(x, rowNumber).getContents().equals(""));
        return ligne;
    }

    @Override
    public Collection<Double> takeLineDouble(int sheetNumber, int rowNumber) {
        Collection<Double> ligne = new ArrayList<Double>();
        int numberOfSheets = workbook.getNumberOfSheets();
        String contentValue = null;
        double value;
        if (sheetNumber >= numberOfSheets || sheetNumber < 0){
            throw new IllegalArgumentException("sheetNumber is not correct!");
        }
        Sheet sheet = workbook.getSheet(sheetNumber);

        int x = 1;
        do{
            contentValue = sheet.getCell(x, rowNumber).getContents().trim();
            try{
                value = Double.parseDouble(contentValue.replace(',','.'));
            }catch  (Exception e){
                value = -1;
            }
            ligne.add(value);
            x++;
        }while (!sheet.getCell(x, rowNumber).getContents().equals(""));
        return ligne;
    }

    @Override
    public Collection<String> takeAllCountry() {
        Collection<String> country = new ArrayList<String>();
        Sheet sheet = workbook.getSheet(0);
        String contentValue = null;

        int y = 1;
        do{
            contentValue = sheet.getCell(0, y).getContents();
            country.add(contentValue.trim());
            y++;
        }while (!sheet.getCell(0, y).getContents().equals(""));
        return country;
    }

    @Override
    public Collection<String> takeAllYears() {
        Collection<String> years = new ArrayList<String>();
        Sheet sheet = workbook.getSheet(0);
        String contentValue = null;

        int x = 1;
        do{
            contentValue = sheet.getCell(x,0).getContents();
            years.add(contentValue.trim());
            x++;
        }while (!sheet.getCell(x,0).getContents().equals(""));
        return years;
    }

    @Override
    public int takeNumberOfLine(int sheet) {
        Sheet sheets = workbook.getSheet(sheet);
        int y = 1;
        do{
            y++;
        }while (!sheets.getCell(0, y).getContents().equals(""));
        return --y;
    }

    @Override
    public Collection<ArrayList<String>> takeAllLineString(int sheet) {
        Collection<ArrayList<String>> collection = new ArrayList<ArrayList<String>>();
        int y = 1;
        do {
            collection.add((ArrayList<String>) takeLineString(sheet,y));
            y++;
        }while(y<=takeNumberOfLine(sheet));
        return collection;
    }

    @Override
    public Collection<ArrayList<Double>> takeAllLineDouble(int sheet) {
        Collection<ArrayList<Double>> collection = new ArrayList<ArrayList<Double>>();
        int y = 1;
        do {
            collection.add((ArrayList<Double>) takeLineDouble(sheet, y));
            y++;
        }while(y<=takeNumberOfLine(sheet));
        return collection;
    }

    @Override
    public Collection<ArrayList<ArrayList<String>>> takeAllSheetLineString() {
        Collection<ArrayList<ArrayList<String>>> allSheet = new ArrayList<ArrayList<ArrayList<String>>>();
        int sheet = 0;
        do {
            allSheet.add((ArrayList<ArrayList<String>>) takeAllLineString(sheet));
            sheet++;
        }while(sheet < workbook.getNumberOfSheets());
        return allSheet;
    }

    @Override
    public Collection<ArrayList<ArrayList<Double>>> takeAllSheetLineDouble() {
        Collection<ArrayList<ArrayList<Double>>> allSheet = new ArrayList<ArrayList<ArrayList<Double>>>();
        int sheet = 0;
        do {
            allSheet.add((ArrayList<ArrayList<Double>>) takeAllLineDouble(sheet));
            sheet++;
        }while(sheet < workbook.getNumberOfSheets());
        return allSheet;
    }

    @Override
    public String getCountry(int row) {
        Sheet sheet = workbook.getSheet(0);
        String content = sheet.getCell(0, row).getContents().trim();
        return content;
    }

    @Override
    public String getYear(int column) {
        Sheet sheet = workbook.getSheet(0);
        String content = sheet.getCell(column, 0).getContents().trim();
        return content;
    }

    @Override
    public Collection<String> getAllNameSheet() {
        Collection<String> sheetNames = new ArrayList<String>();
        String[] sheetsName = new String[workbook.getNumberOfSheets()];
        sheetsName = workbook.getSheetNames();
        for (String sheet : sheetsName) {
            sheetNames.add(sheet);
        }
        return sheetNames;
    }

    @Override
    public String getNameSheet(int sheet) {
        String[] sheetsName = new String[workbook.getNumberOfSheets()];
        sheetsName = workbook.getSheetNames();
        return sheetsName[sheet];
    }
}