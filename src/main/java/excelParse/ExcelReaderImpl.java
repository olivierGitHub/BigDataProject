package excelParse;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
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
    public Collection<String> takeLineString(int sheetNumber, int ligneNumber) throws IllegalArgumentException{
        Collection<String> ligne = new ArrayList<String>();
        int numberOfSheets = workbook.getNumberOfSheets();
        String contentValue = null;
        if (sheetNumber >= numberOfSheets || sheetNumber < 0){
            throw new IllegalArgumentException("sheetNumber is not correct!");
        }
        Sheet sheet = workbook.getSheet(sheetNumber);

        int x = 1;
        do{
            contentValue = sheet.getCell(x, ligneNumber).getContents();
            ligne.add(contentValue.trim());
            x++;
        }while (!sheet.getCell(x, ligneNumber).getContents().equals(""));
        return ligne;
    }

    @Override
    public Collection<Double> takeLineDouble(int sheetNumber, int ligneNumber) {
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
            contentValue = sheet.getCell(x, ligneNumber).getContents().trim();
            try{
                value = Double.parseDouble(contentValue.replace(',','.'));
            }catch  (Exception e){
                value = -1;
            }
            ligne.add(value);
            x++;
        }while (!sheet.getCell(x, ligneNumber).getContents().equals(""));
        return ligne;
    }

    @Override
    public Collection<String> takePays() {
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
    public Collection<String> takeYears() {
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

}