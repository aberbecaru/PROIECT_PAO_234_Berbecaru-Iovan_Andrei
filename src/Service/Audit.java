package Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Audit{
    private static final String path = "src/Files/audit.csv";
    private static Audit instance;
    private Audit(){

    }

    public static Audit getInstance(){
        if(instance == null){
            instance = new Audit();
        }
        return instance;
    }

    public void write(String action){
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)))){
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatDateTime = now.format(formatter);
            out.println(action + "," + formatDateTime);

        }catch(IOException e){
            System.err.println("Error writing to file" + e.getMessage());
        }
    }
}