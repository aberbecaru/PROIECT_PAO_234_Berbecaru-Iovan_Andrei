package config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfiguration {
    private Connection connection;

    public Connection getConnection(){
        return connection;
    }

    public DatabaseConfiguration(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/Files/dbinfo.csv"));

            String[] dbInfo = br.readLine().split(",");
            String url = dbInfo[0].trim();
            String username = dbInfo[1].trim();
            String password = "";

            connection = DriverManager.getConnection(url, username, password);
        }
        catch(IOException e){
            System.out.println("The authentification proccess failed");
        }

        catch(SQLException e){
            System.out.println("The connection to the database failed");
        }
    }
}
