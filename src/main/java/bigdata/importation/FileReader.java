package bigdata.importation;

import jxl.read.biff.BiffException;

import java.io.IOException;
import java.util.List;

/**
 * Created by alco on 10/02/2015.
 */
public interface FileReader {
    void takeReader(String workbook) throws IOException, BiffException;
    List<RateItem> getFileRate();
}
