package bigdata.importation;

import bigdata.importation.excel.ExcelReader;
import jxl.read.biff.BiffException;

import javax.inject.Named;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by alexandre on 18/02/2015.
 */
public interface ImportationService {
    void importFileData(File file);
}
