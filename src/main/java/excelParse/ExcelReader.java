package excelParse;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by alco on 10/02/2015.
 */
public interface ExcelReader {
    Collection<String> takeLineString(int sheetNumber, int ligneNumber);
    Collection<Double> takeLineDouble(int sheetNumber, int ligneNumber);
    Collection<String> takePays();
    Collection<String> takeYears();
    int takeNumberOfLine(int sheet);
    Collection<ArrayList<String>> takeAllLineString(int sheet);
    Collection<ArrayList<ArrayList<String>>> takeAllSheetLineString();

}
