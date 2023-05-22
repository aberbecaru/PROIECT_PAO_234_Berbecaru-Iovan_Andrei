package Singleton;

import Peoples.Coach;
import Useful.Sports;
import The_Complex.Sponsor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class SponsorSingleton {

    private static SponsorSingleton instance = null;
    private ArrayList<Sponsor> sponsors = new ArrayList<Sponsor>();

    public static SponsorSingleton getInstance() {
        if (instance == null) {
            instance = new SponsorSingleton();
        }
        return instance;
    }

    public static void setInstance(SponsorSingleton instance) {
        SponsorSingleton.instance = instance;
    }

    public ArrayList<Sponsor> readSponsorCSV(){
        String path = "src/Files/sponsors.csv";
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine();
            if(line == null){
                System.out.println("File is empty");
            }
            else{
                while(line != null){
                    String[] data = line.split(",");
                    var newSponsor = new Sponsor(Integer.parseInt(data[0]), data[1], data[2], data[3], Integer.parseInt(data[4]));
                    sponsors.add(newSponsor);
                    line = br.readLine();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return sponsors;
    }

    public void writeSponsorCSV(ArrayList<Sponsor> sponsors){
        try{
            var writer = new FileWriter("src/Files/sponsors.csv");
            for(var Sponsor: sponsors){
                writer.write(Sponsor.toCSV());
                writer.write("\n");
            }

            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
