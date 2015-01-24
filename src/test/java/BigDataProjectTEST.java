import data.Data;
import org.testng.annotations.BeforeMethod;
import static org.fest.assertions.api.Assertions.assertThat;

import org.testng.annotations.Test;
import parse.ParseCSV;
import parse.ReadCSV;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oliver on 24/01/15.
 */
public class BigDataProjectTEST {


    String file;
    String fileTest;

    @BeforeMethod
    public void createFile() throws Exception {
        fileTest = "essai.csv";
        file = "OCDE_file.csv";
    }

    private BufferedReader getBufferedReader() {
        ReadCSV csv = new ReadCSV(file);
        return csv.readFile();
    }

    @Test
    public void shouldReadCSV(){
        BufferedReader br = getBufferedReader();

        assertThat(br).isNotNull();
    }



    @Test
    public void shouldParseFileToDataObject(){
        BufferedReader br = getBufferedReader();
        ParseCSV parse = new ParseCSV(br);
        List<Data> list = new ArrayList<Data>();

        list = parse.parseCsvFile();

        assertThat(list).isNotEmpty();
    }


    //@Test(expectedExceptions = FileNotFoundException.class)
    public void shouldThrowsFileNotFoundException(){
        ReadCSV csv = new ReadCSV("essai3.csv");
        BufferedReader br = csv.readFile();
    }


}
