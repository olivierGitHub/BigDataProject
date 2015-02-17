package excelParse;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import model.RateGroupType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alco on 09/02/2015.
 */
public class ExcelReaderImpl implements FileReader {
    Workbook workbook;
    private static final String CURRENCY_UNIT = "Unite monetaire";
    private static final double DEFAULT_VALUE_THREEDOT = -1;

    public ExcelReaderImpl(){}

    @Override
    public void takeReader(String workbook) throws IOException, BiffException {
        this.workbook = Workbook.getWorkbook(new File(workbook));
    }

    
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

    
    public int takeNumberOfLine(int sheet) {
        Sheet sheets = workbook.getSheet(sheet);
        int y = 1;
        do{
            y++;
        }while (!sheets.getCell(0, y).getContents().equals(""));
        return --y;
    }

    
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
    
    public ArrayList<ArrayList<Double>> takeAllLineDouble(int sheet) {
        ArrayList<ArrayList<Double>> collection = new ArrayList<ArrayList<Double>>();
        int y = 1;
        do {
            collection.add((ArrayList<Double>) takeLineDouble(sheet, y));
            y++;
        }while(y<=takeNumberOfLine(sheet));
        return collection;
    }

    
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
    
    public ArrayList<ArrayList<ArrayList<Double>>> takeAllSheetLineDouble() {
        ArrayList<ArrayList<ArrayList<Double>>> allSheet = new ArrayList<ArrayList<ArrayList<Double>>>();
        int sheet = 0;
        do {
            allSheet.add((ArrayList<ArrayList<Double>>) takeAllLineDouble(sheet));
            sheet++;
        }while(sheet < workbook.getNumberOfSheets());
        return allSheet;
    }

    
    public String getCountry(int row) {
        Sheet sheet = workbook.getSheet(0);
        String content = sheet.getCell(0, row).getContents().trim();
        return content;
    }

    
    public String getYear(int column) {
        Sheet sheet = workbook.getSheet(0);
        String content = sheet.getCell(column, 0).getContents().trim();
        return content;
    }

    
    public ArrayList<String> getAllNameSheet() {
        ArrayList<String> sheetNames = new ArrayList<String>();
        String[] sheetsName = new String[workbook.getNumberOfSheets()];
        sheetsName = workbook.getSheetNames();
        for (String sheet : sheetsName) {
            sheetNames.add(sheet);
        }
        return sheetNames;
    }

    
    public String getNameSheet(int sheet) {
        String[] sheetsName = new String[workbook.getNumberOfSheets()];
        sheetsName = workbook.getSheetNames();
        return sheetsName[sheet];
    }

    /***
     * @param y
     * @return
     * @return null if bad y
     */
    
    public String getUniteMonetaire(int y) {
        int z = 0;
        while(!(workbook.getSheet(2).getCell(z, 0).getContents().equals(CURRENCY_UNIT))){
            z++;
        }
        
        String content = workbook.getSheet(2).getCell(z,y).getContents();
        if(content.equals(DEFAULT_VALUE_THREEDOT)){
            throw new IllegalArgumentException("This country have no Currency Unit!");
        }
        else if(content.equals("")){
            throw new IllegalArgumentException("Bad indice have no country in correspondance!");
        }
        else if(content.equals(CURRENCY_UNIT)){
            throw new IllegalArgumentException("Bad indice you found the title!");
        }
        return content.trim();
    }

    
    public ArrayList<String> getAllUniteMonetaire() {
        int z = 0;
        int y = 1;
        ArrayList<String> content = new ArrayList<String>();
        while(!(workbook.getSheet(2).getCell(z, 0).getContents().equals(CURRENCY_UNIT))){
            z++;
        }

        while(!workbook.getSheet(2).getCell(z,y).getContents().equals("")){
            content.add(workbook.getSheet(2).getCell(z,y).getContents().trim());
            y++;
        }
        
        return content;
    }

    /***
     * @return List<RateItem>
     */
    @Override
    public List<RateItem> getFileRate() {
        List<RateItem> rateItemList = new ArrayList<RateItem>();
        
        String contentValue = "";
        Double tauxValue = -1.0;
        int sheetNumber = 0;

        ArrayList<String> sheetNameList = getAllNameSheet();

        for (String nameSheet : sheetNameList) {
            System.out.println(nameSheet);  //*********************************************
            Sheet sheet = workbook.getSheet(sheetNumber);
            try {
                RateGroupType rateGrouptype = RateGroupType.valueOf(nameSheet);
                int x = 1, y = 1;
                do{
//                    System.out.println("y = " + y);  //*********************************************
                    do{
//                        System.out.println("x = " + x);  //*********************************************
                        contentValue = sheet.getCell(x, y).getContents().trim();
                        try{
                            tauxValue = Double.parseDouble(contentValue.replace(',','.'));
                            RateValue rateValue = new RateValue(tauxValue,getUniteMonetaire(y));
//                            System.out.println("rateValue = " + rateValue);  //*********************************************
                            RateKey rateKey = new RateKey(getCountry(y),getYear(y),nameSheet);
//                            System.out.println("rateKey = " + rateKey);  //*********************************************
                            RateItem rateItem = new RateItem(rateKey,rateValue);
//                            System.out.println("rateItem = " + rateItem);  //*********************************************
                            rateItemList.add(rateItem);
                        }catch  (Exception e1){
                            e1.printStackTrace();
                        }
                        x++;
                    }while (!sheet.getCell(x, y).getContents().equals(""));
                    y++; x = 1;
                }while (!sheet.getCell(x, y).getContents().equals("") && x<= takeNumberOfLine(sheetNumber));
                sheetNumber++;
            }catch (Exception e){
            }
        }
        
        return rateItemList;
    }
}