package Singleton;
import Grounds.Football;
import Peoples.Coach;
import Useful.Exposure;
import Useful.Lighting;
import Useful.Sports;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class FootballSingleton {
    private static FootballSingleton instance = null;
    private ArrayList<Football> football_grounds = new ArrayList<Football>();

    public static FootballSingleton getInstance() {
        if (instance == null) {
            instance = new FootballSingleton();
        }
        return instance;
    }

    public static void setInstance(FootballSingleton instance) {
        FootballSingleton.instance = instance;
    }

    public ArrayList<Football> readFootballCSV(){
        String path = "src/Files/football_grounds.csv";
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
                    var newFootball = new Football(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Exposure.valueOf(data[2]), Lighting.valueOf(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]));
                    football_grounds.add(newFootball);
                    line = br.readLine();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return football_grounds;
    }

    public void writeFootballCSV(ArrayList<Football> football_grounds){
        try{
            var writer = new FileWriter("src/Files/football_grounds.csv");
            for(var football: football_grounds){
                writer.write(football.toCSV());
                writer.write("\n");
            }

            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
