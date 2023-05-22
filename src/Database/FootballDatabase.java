package Database;

import Grounds.Football;
import Peoples.Member;
import Useful.*;
import config.DatabaseConfiguration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FootballDatabase {
    private final DatabaseConfiguration databaseConfiguration;

    public FootballDatabase(DatabaseConfiguration dbConfig){
        databaseConfiguration = dbConfig;
    }

    public ArrayList<Football> readFootballDB() throws SQLException {
        Statement statement = databaseConfiguration.getConnection().createStatement();

        String sql = "SELECT * from project_database.football_grounds";
        ResultSet resultSet = statement.executeQuery(sql);

        ArrayList<Football> football_grounds = new ArrayList<>();

        while(resultSet.next()){
            int id = resultSet.getInt("id");
            int capacity = resultSet.getInt("capacity");
            Exposure exposure = resultSet.getString("exposure").equals("INDOOR") ? Exposure.INDOOR : Exposure.OUTDOOR;
            Lighting lighting = resultSet.getString("lighting").equals("NATURAL") ? Lighting.NATURAL : Lighting.NOCTURNE;
            int length = resultSet.getInt("length");
            int width = resultSet.getInt("width");

            Football football_ground = new Football(id, capacity, exposure, lighting, length, width);
            football_grounds.add(football_ground);

        }

        resultSet.close();
        statement.close();

        return football_grounds;

    }

    public void addFootballDB(Football football_ground) throws SQLException{
        try{
            String sql = "INSERT INTO football_grounds (id, capacity, exposure, lighting, length, width) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = databaseConfiguration.getConnection().prepareStatement(sql);

            statement.setInt(1, football_ground.getId());
            statement.setInt(2, football_ground.getCapacity());
            statement.setString(3, football_ground.getExposure().toString());
            statement.setString(4, football_ground.getLighting().toString());
            statement.setInt(5, football_ground.getLength());
            statement.setInt(6, football_ground.getWidth());

            statement.executeUpdate();
            statement.close();

            System.out.println("Member added successfully");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteFootballDB(int id) throws SQLException{
        try {
            String sql = "DELETE FROM football_grounds WHERE id = ?";
            PreparedStatement statement = databaseConfiguration.getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
            statement.close();
            System.out.println("Football ground deleted successfully");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateFootballDB(Football football_ground) throws SQLException {
        try {
            String sql = "UPDATE football_grounds set capacity = ?, exposure = ?, lighting = ?, length = ?, width = ? WHERE id = ?";
            PreparedStatement statement = databaseConfiguration.getConnection().prepareStatement(sql);

            statement.setInt(1, football_ground.getCapacity());
            statement.setString(2, football_ground.getExposure().toString());
            statement.setString(3, football_ground.getLighting().toString());
            statement.setInt(4, football_ground.getLength());
            statement.setInt(5, football_ground.getWidth());
            statement.setInt(6, football_ground.getId());

            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if (rowsUpdated > 0) {
                System.out.println("Football ground updated successfully");
            } else {
                System.out.println("Football ground not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
