package Excel;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by alexandre on 30/01/2015.
 */
public class JExcelAPITest {
    
    @Test
    public void TestGetContent3Dot(){
        String a1 = null;
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(new File("OCDE_file.xls"));
            Sheet sheet = workbook.getSheet(0);
            a1 = sheet.getCell(3, 3).getContents();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        assertThat(a1).isEqualTo("...");
    }

    @Test
    public void TestGetContentDate(){
        String a1 = null;
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(new File("OCDE_file.xls"));
            Sheet sheet = workbook.getSheet(0);
            a1 = sheet.getCell(5, 0).getContents();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        assertThat(a1).isEqualTo("2003");
    }

    @Test
    public void TestGetContentPays(){
        String a1 = null;
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(new File("OCDE_file.xls"));
            Sheet sheet = workbook.getSheet(0);
            a1 = sheet.getCell(0, 5).getContents();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        assertThat(a1).isEqualTo("Chili");
    }

    @Test
    public void TestGetContentNumber(){
        String a1 = null;
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(new File("OCDE_file.xls"));
            Sheet sheet = workbook.getSheet(0);
            a1 = sheet.getCell(1, 5).getContents();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        String a = a1.trim();
        assertThat(a).isEqualTo("11,0");
    }
    
    @Test
    public void TestGetContentVoid(){
        String a1 = null;
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(new File("OCDE_file.xls"));
            Sheet sheet = workbook.getSheet(0);
            a1 = sheet.getCell(20, 0).getContents();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        assertThat(a1).isEqualTo("");
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void TestGetSheetWasNoExiste(){
        String a1 = null;
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(new File("OCDE_file.xls"));
            Sheet sheet = workbook.getSheet(5);
            a1 = sheet.getCell(0, 0).getContents();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        assertThat(a1).isEqualTo("");
    }

    @Test
    public void TestGetContentNumberParsing(){
        String a = "11,0";
        double found = 0;
        try {
             found = Double.parseDouble(a.replace(",","."));
        }catch (Exception e){
            System.out.println("e = " + e);
        }
        assertThat(found).isEqualTo(11);
    }

    @Test
    public void TestGetContentDateParsing(){
        String a1 = null;
        Workbook workbook = null;
        int date = 0;
        try {
            workbook = Workbook.getWorkbook(new File("OCDE_file.xls"));
            Sheet sheet = workbook.getSheet(0);
            date = Integer.parseInt(sheet.getCell(5, 0).getContents().trim());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        
        assertThat(date).isEqualTo(2003);
    }
}
