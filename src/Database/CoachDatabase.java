package Database;

import Peoples.*;
import Useful.*;
import config.DatabaseConfiguration;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CoachDatabase {

    private final DatabaseConfiguration databaseConfiguration;

    public CoachDatabase(DatabaseConfiguration dbConfig){
        databaseConfiguration = dbConfig;
    }

    public ArrayList<Coach> readCoachDB() throws SQLException{
        Statement statement = databaseConfiguration.getConnection().createStatement();

        String sql = "SELECT * from project_database.coaches";
        ResultSet resultSet = statement.executeQuery(sql);

        ArrayList<Coach> coaches = new ArrayList<>();

        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            int age = resultSet.getInt("age");
            int employedTime = resultSet.getInt("employedTime");
            Sports sport = resultSet.getString("sport").equals("TENNIS") ? Sports.TENNIS : Sports.FOOTBALL;
            int experience = resultSet.getInt("experience");

            Coach coach = new Coach(id, firstName, lastName, age, employedTime, sport, experience);
            coaches.add(coach);
        }

        resultSet.close();
        statement.close();

        return coaches;

    }

    public void addCoachDB(Coach coach) throws SQLException {
        try {
            String sql = "INSERT INTO coaches (id, firstName, lastName, age, employedTime, sport, experience ) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = databaseConfiguration.getConnection().prepareStatement(sql);

            statement.setInt(1, coach.getId());
            statement.setString(2, coach.getFirstName());
            statement.setString(3, coach.getLastName());
            statement.setInt(4, coach.getAge());
            statement.setInt(5, coach.getEmployedTime());
            statement.setString(6, coach.getSport().toString());
            statement.setInt(7, coach.getExperience());

            statement.executeUpdate();
            statement.close();

            System.out.println("Coach added successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCoachDB(int id) throws SQLException{
        try {
            String sql = "DELETE FROM coaches WHERE id = ?";
            PreparedStatement statement = databaseConfiguration.getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
            statement.close();
            System.out.println("Coach deleted successfully");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateCoachDB(Coach coach) throws SQLException{
        try{
            String sql = "UPDATE coaches set firstName = ?, lastName = ?, age = ?, employedTime = ?, sport = ?, experience = ? WHERE id = ?";
            PreparedStatement statement = databaseConfiguration.getConnection().prepareStatement(sql);

            statement.setString(1, coach.getFirstName());
            statement.setString(2, coach.getLastName());
            statement.setInt(3, coach.getAge());
            statement.setInt(4, coach.getEmployedTime());
            statement.setString(5, coach.getSport().toString());
            statement.setInt(6, coach.getExperience());
            statement.setInt(7, coach.getId());

            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if (rowsUpdated > 0) {
                System.out.println("Coach updated successfully");
            } else {
                System.out.println("No coach found with the provided ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
