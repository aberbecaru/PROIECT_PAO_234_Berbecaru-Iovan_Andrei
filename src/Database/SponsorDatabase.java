package Database;

import Peoples.Member;
import The_Complex.Sponsor;
import config.DatabaseConfiguration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SponsorDatabase {

    private final DatabaseConfiguration databaseConfiguration;

    public SponsorDatabase(DatabaseConfiguration dbConfig){
        databaseConfiguration = dbConfig;
    }

    public ArrayList<Sponsor> readSponsorDB() throws SQLException{
        Statement statement = databaseConfiguration.getConnection().createStatement();

        String sql = "SELECT * from project_database.sponsors";
        ResultSet resultSet = statement.executeQuery(sql);

        ArrayList<Sponsor> sponsors = new ArrayList<>();

        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String sponsorName = resultSet.getString("sponsorName");
            String contactInformation = resultSet.getString("contactInformation");
            String sponsorType = resultSet.getString("sponsorType");
            int contributionAmount = resultSet.getInt("contributionAmount");

            Sponsor sponsor = new Sponsor(id, sponsorName, contactInformation, sponsorType, contributionAmount);
            sponsors.add(sponsor);
        }

        resultSet.close();
        statement.close();

        return sponsors;
    }

    public void addSponsorDB(Sponsor sponsor) throws SQLException{
        try{
            String sql = "INSERT INTO sponsors (id, sponsorName, contactInformation, sponsorType, contributionAmount) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = databaseConfiguration.getConnection().prepareStatement(sql);

            statement.setInt(1, sponsor.getId());
            statement.setString(2, sponsor.getSponsorName());
            statement.setString(3, sponsor.getContactInformation());
            statement.setString(4, sponsor.getSponsorType());
            statement.setDouble(5, sponsor.getContributionAmount());

            statement.executeUpdate();
            statement.close();

            System.out.println("Sponsor added to database");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteSponsorDB(int id) throws SQLException{
        try{
            String sql = "DELETE FROM sponsors WHERE id = ?";
            PreparedStatement statement = databaseConfiguration.getConnection().prepareStatement(sql);

            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();

            System.out.println("Sponsor deleted from database");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateSponsorDB(Sponsor sponsor) throws SQLException{
        try{
            String sql = "Update sponsors SET sponsorName = ?, contactInformation = ?, sponsorType = ?, contributionAmount = ? WHERE id = ?";
            PreparedStatement statement = databaseConfiguration.getConnection().prepareStatement(sql);

            statement.setString(1, sponsor.getSponsorName());
            statement.setString(2, sponsor.getContactInformation());
            statement.setString(3, sponsor.getSponsorType());
            statement.setDouble(4, sponsor.getContributionAmount());
            statement.setInt(5, sponsor.getId());

            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if (rowsUpdated > 0) {
                System.out.println("Sponsor updated successfully");
            } else {
                System.out.println("No sponsor found with the provided ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
