package bigdata.importation;

import bigdata.importation.excel.ExcelReader;
import jxl.read.biff.BiffException;

import javax.inject.Named;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandre on 18/02/2015.
 */

@Named
public class ImportationService {
    
    public void importFileData(File file){
        FileReader excelReader = new ExcelReader();
        try {
            excelReader.takeReader(file);
            List<RateItem> rateItemList = excelReader.getFileRate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }
    
    public List<String> getYearFileData(File file){
        List<String> resultList = new ArrayList<String>();
        FileReader excelReader = new ExcelReader();
        try {
            excelReader.takeReader(file);
            resultList = excelReader.getAllYears();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
