package excelParse;

import java.util.Collection;

/**
 * Created by alco on 10/02/2015.
 */
public interface ExcelReader {
    Collection<String> takeLineString(int sheetNumber, int ligneNumber);
    Collection<Double> takeLineDouble(int sheetNumber, int ligneNumber);
    Collection<String> takePays();
    Collection<String> takeYears();
}
