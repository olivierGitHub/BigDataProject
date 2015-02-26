package bigdata.importation;

import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alco on 10/02/2015.
 */
public interface FileReader {
    void takeReader(String workbook) throws IOException, BiffException;
    void takeReader(File file) throws IOException, BiffException;
    List<String> getAllYears();
    List<RateItem> getFileRate();
    ArrayList<String> getAllNameSheet();
}