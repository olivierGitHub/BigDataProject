package excelParse;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by alco on 09/02/2015.
 */
public class ExcelReaderImpl implements ExcelReader{
    Workbook workbook;
    private double DEFAULT_VALUE_THREEDOT = -1;
    public ExcelReaderImpl(String workbook) throws IOException,BiffException{
        this.workbook = Workbook.getWorkbook(new File(workbook));
    }

    @Override
    public ArrayList<String> takeLineString(int sheetNumber, int rowNumber) throws IllegalArgumentException{
        ArrayList<String> ligne = new ArrayList<String>();
        int numberOfSheets = workbook.getNumberOfSheets();
        String contentValue = null;
        if (sheetNumber >= numberOfSheets || sheetNumber < 0){
            throw new IllegalArgumentException("sheetNumber is not correct!");
        }
        if (rowNumber <= 0 || rowNumber > takeNumberOfLine(sheetNumber)){
            throw new IllegalArgumentException("rowNumber is not correct!");
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

    /***
     *  Return -1 for all cells have "..." value
     * @param sheetNumber
     * @param rowNumber
     * @return
     */
    @Override
    public ArrayList<Double> takeLineDouble(int sheetNumber, int rowNumber) {
        ArrayList<Double> ligne = new ArrayList<Double>();
        int numberOfSheets = workbook.getNumberOfSheets();
        String contentValue = null;
        double value;
        if (sheetNumber >= numberOfSheets || sheetNumber < 0){
            throw new IllegalArgumentException("sheetNumber is not correct!");
        }
        if (rowNumber <= 0 || rowNumber > takeNumberOfLine(sheetNumber)){
            throw new IllegalArgumentException("rowNumber is not correct!");
        }
        Sheet sheet = workbook.getSheet(sheetNumber);

        int x = 1;
        do{
            contentValue = sheet.getCell(x, rowNumber).getContents().trim();
            try{
                value = Double.parseDouble(contentValue.replace(',','.'));
            }catch  (Exception e){
                value = DEFAULT_VALUE_THREEDOT;
            }
            ligne.add(value);
            x++;
        }while (!sheet.getCell(x, rowNumber).getContents().equals(""));
        return ligne;
    }

    @Override
    public ArrayList<String> getAllCountry() {
        ArrayList<String> country = new ArrayList<String>();
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
    public ArrayList<String> getAllYears() {
        ArrayList<String> years = new ArrayList<String>();
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
    public ArrayList<ArrayList<String>> takeAllLineString(int sheet) {
        ArrayList<ArrayList<String>> collection = new ArrayList<ArrayList<String>>();
        int y = 1;
        do {
            collection.add((ArrayList<String>) takeLineString(sheet,y));
            y++;
        }while(y<=takeNumberOfLine(sheet));
        return collection;
    }

    /***
     * Return -1 for all cells have "..." value
     * @param sheet
     * @return
     */
    @Override
    public ArrayList<ArrayList<Double>> takeAllLineDouble(int sheet) {
        ArrayList<ArrayList<Double>> collection = new ArrayList<ArrayList<Double>>();
        int y = 1;
        do {
            collection.add((ArrayList<Double>) takeLineDouble(sheet, y));
            y++;
        }while(y<=takeNumberOfLine(sheet));
        return collection;
    }

    @Override
    public ArrayList<ArrayList<ArrayList<String>>> takeAllSheetLineString() {
        ArrayList<ArrayList<ArrayList<String>>> allSheet = new ArrayList<ArrayList<ArrayList<String>>>();
        int sheet = 0;
        do {
            allSheet.add((ArrayList<ArrayList<String>>) takeAllLineString(sheet));
            sheet++;
        }while(sheet < workbook.getNumberOfSheets());
        return allSheet;
    }

    /***
     * Return -1 for all cells have "..." value
     * @return
     */
    @Override
    public ArrayList<ArrayList<ArrayList<Double>>> takeAllSheetLineDouble() {
        ArrayList<ArrayList<ArrayList<Double>>> allSheet = new ArrayList<ArrayList<ArrayList<Double>>>();
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
    public ArrayList<String> getAllNameSheet() {
        ArrayList<String> sheetNames = new ArrayList<String>();
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

/*    @Override
    public String getUniteMonetaire(int y) {
        String cell;
        Range[] foundCell;
        foundCell = workbook.findByName("Unite monetaire");
        cell = workbook.find

        return null;
    }*/
}