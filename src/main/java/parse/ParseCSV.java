package parse;

import data.DataTaux;

import java.io.BufferedReader;
import java.io.IOException;
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

    public List<DataTaux> parseCsvFile(){
        List<DataTaux> list = new ArrayList<DataTaux>();
        StringTokenizer st = null;
        String line = null;
        int count=0;

        try{
            while ((line=br.readLine())!=null){
                DataTaux dataTaux = new DataTaux();
                st = new StringTokenizer(line,";");
                while (st.hasMoreTokens()){
                    count++;
                    if (count==1)
                        dataTaux.setCountry(st.nextToken());

                    else if (count==13)
                        dataTaux.setYear2011(st.nextToken());
                    else if (count==14)
                        dataTaux.setYear2012(st.nextToken());
                    else if (count==15)
                        dataTaux.setYear2013(st.nextToken());
                    else if (count==16)
                        dataTaux.setYear2014(st.nextToken());
                    else
                        st.nextToken();
                }
                list.add(dataTaux);
                count =0;
                }
        }catch(IOException ioEx){
              ioEx.printStackTrace();
            }
        return list;
        }
    }




