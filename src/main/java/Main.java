import data.DataTaux;
import parse.ParseCSV;
import parse.ReadCSV;
import persistence.DaoData;

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

        List<DataTaux> list = new ArrayList<DataTaux>();

        list = parse.parseCsvFile();
        for(DataTaux dataTaux : list){
            DaoData.getInstance().create(dataTaux);
            System.out.println(dataTaux.getCountry());
        }

        DataTaux dataTaux = DaoData.getInstance().read(4);
        System.out.println("It works, let's go to " + dataTaux.getCountry());

        System.exit(0);
    }
}
