package Singleton;
import Peoples.Coach;
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


public class CoachSingleton {
    private static CoachSingleton instance = null;
    private ArrayList<Coach> coaches = new ArrayList<Coach>();

    public static CoachSingleton getInstance() {
        if (instance == null) {
            instance = new CoachSingleton();
        }
        return instance;
    }

    public static void setInstance(CoachSingleton instance) {
        CoachSingleton.instance = instance;
    }

    public ArrayList<Coach> readCoachCSV(){
        String path = "src/Files/coaches.csv";
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
                    var newCoach = new Coach(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Sports.valueOf(data[5]), Integer.parseInt(data[6]));
                    coaches.add(newCoach);
                    line = br.readLine();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return coaches;
    }

    public void writeCoachCSV(ArrayList<Coach> coaches){
        try{
            var writer = new FileWriter("src/Files/coaches.csv");
            for(var coach: coaches){
                writer.write(coach.toCSV());
                writer.write("\n");
            }

            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}

