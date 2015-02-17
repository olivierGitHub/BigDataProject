import bigdata.parse.ParseCSV;
import bigdata.parse.ReadCSV;
import data.DataTaux;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by oliver on 24/01/15.
 */
public class BigDataProjectTEST {


    String file;

    @BeforeMethod
    public void createFile() throws Exception {
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
        List<DataTaux> list = new ArrayList<DataTaux>();

        list = parse.parseCsvFile();

        assertThat(list).isNotEmpty();
    }


    //@Test(expectedExceptions = FileNotFoundException.class)
    public void shouldThrowsFileNotFoundException(){
        ReadCSV csv = new ReadCSV("essai.csv");
        BufferedReader br = csv.readFile();
    }


}
