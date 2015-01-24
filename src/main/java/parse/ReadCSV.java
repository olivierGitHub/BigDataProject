package parse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by oliver on 24/01/15.
 */
public class ReadCSV {

    private String file;


    public ReadCSV(String file){
        this.file = file;
    }

    public String getFile(){
        return this.file;
    }

    public BufferedReader readFile(){
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(file));
            return br;
        }catch(IOException ioEx){
            ioEx.printStackTrace();
            return null;
        }
    }

}
