package excelParse;

import java.util.ArrayList;

/**
 * Created by alco on 10/02/2015.
 */
public interface ExcelReader {
    ArrayList<String> takeLineString(int sheetNumber, int rowNumber);
    ArrayList<Double> takeLineDouble(int sheetNumber, int rowNumber);
    ArrayList<String> getAllCountry();
    ArrayList<String> getAllYears();
    int takeNumberOfLine(int sheet);
    ArrayList<ArrayList<String>> takeAllLineString(int sheet);
    ArrayList<ArrayList<Double>> takeAllLineDouble(int sheet);
    ArrayList<ArrayList<ArrayList<String>>> takeAllSheetLineString();
    ArrayList<ArrayList<ArrayList<Double>>> takeAllSheetLineDouble();
    String getCountry(int row);
    String getYear(int column);
    ArrayList<String> getAllNameSheet();
    String getNameSheet(int sheet);
    String getUniteMonetaire(int y);
    ArrayList<String> getAllUniteMonetaire();
}
