package parse;

import data.Data;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by oliver on 24/01/15.
 */
public class ParseCSV {

    private BufferedReader br;


    public ParseCSV(BufferedReader br){
        this.br = br;
    }


    public int countLines(){
        String line;
        int count =0;
        try{
            while ((line = br.readLine())!=null){
                count++;
            }
        }catch(IOException ioEx){
            ioEx.printStackTrace();
        }
        return count;
    }

    public List<Data> parseCsvFile(){
        List<Data> list = new ArrayList<Data>();
        StringTokenizer st = null;
        String line = null;
        int count=0;

        try{
            while ((line=br.readLine())!=null){

                Data data = new Data();
                st = new StringTokenizer(line,";");
                while (st.hasMoreTokens()){
                    count++;
                    if (count==1)
                        data.setCountry(st.nextToken());

                    else if (count==13)
                        data.setYear2011(st.nextToken());
                    else if (count==14)
                        data.setYear2012(st.nextToken());
                    else if (count==15)
                        data.setYear2013(st.nextToken());
                    else if (count==16)
                        data.setYear2014(st.nextToken());
                    else
                        st.nextToken();
                }
                list.add(data);
                count =0;
                }

        }catch(IOException ioEx){
              ioEx.printStackTrace();
            }
        return list;
        }

    }




