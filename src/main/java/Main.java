import data.Data;
import parse.ParseCSV;
import parse.ReadCSV;
import persistence.DAOdata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oliver on 24/01/15.
 */
public class Main {

    public static void main (String[] args){
        String file = "OCDE_file.csv";
        ReadCSV csv = new ReadCSV(file);
        ParseCSV parse = new ParseCSV(csv.readFile());

        List<Data> list = new ArrayList<Data>();

        list = parse.parseCsvFile();
        for(Data data : list){
            DAOdata.getInstance().create(data);
            System.out.println(data.getCountry());
        }
    }
}
