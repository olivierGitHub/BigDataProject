package bigdata.importation.excel;

import bigdata.importation.FileReader;
import bigdata.importation.RateItem;
import bigdata.importation.RateKey;
import bigdata.importation.RateValue;
import jxl.read.biff.BiffException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by alexandre on 17/02/2015.
 */
public class GetFileRateTest {
    private static final String OCDE_FILE = "OCDE_file.xls";

/*    @Test
    public void shouldGetRateFileCorrectly(){
        try {
            FileReader excelReader = new ExcelReader();
            excelReader.takeReader(OCDE_FILE);
            List<RateItem> found = excelReader.getFileRate();
            for (RateItem rateItem : found) {
                RateKey foundRateKey = rateItem.getRateKey();
                RateValue foundRateValue = rateItem.getRateValue();
                System.out.println(foundRateKey.toString());
                System.out.println(foundRateValue.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("End!");
    }*/

    @Test
    public void shouldGetRateFile(){
        try {
            File f=new File(OCDE_FILE);
            FileReader excelReader = new ExcelReader();
            excelReader.takeReader(f);
            List<RateItem> found = excelReader.getFileRate();
            for (RateItem rateItem : found) {
                RateKey foundRateKey = rateItem.getRateKey();
                RateValue foundRateValue = rateItem.getRateValue();
                System.out.println(foundRateKey.toString());
                System.out.println(foundRateValue.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("End!");
    }
}
