package excelParse;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by alco on 10/02/2015.
 */
public interface ExcelReader {
    Collection<String> takeLineString(int sheetNumber, int rowNumber);
    Collection<Double> takeLineDouble(int sheetNumber, int rowNumber);
    Collection<String> takeAllCountry();
    Collection<String> takeAllYears();
    int takeNumberOfLine(int sheet);
    Collection<ArrayList<String>> takeAllLineString(int sheet);
    Collection<ArrayList<Double>> takeAllLineDouble(int sheet);
    Collection<ArrayList<ArrayList<String>>> takeAllSheetLineString();
    Collection<ArrayList<ArrayList<Double>>> takeAllSheetLineDouble();
    String getCountry(int row);
    String getYear(int column);
    Collection<String> getAllNameSheet();
    String getNameSheet(int sheet);
}
