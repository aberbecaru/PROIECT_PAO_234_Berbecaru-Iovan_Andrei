package Database;

import Peoples.Member;
import Useful.Sports;

import Useful.Sports;
import config.DatabaseConfiguration;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDatabase {
    private final DatabaseConfiguration databaseConfiguration;

    public MemberDatabase(DatabaseConfiguration dbConfig){
        databaseConfiguration = dbConfig;
    }

    public ArrayList<Member> readMemberDB() throws SQLException{
        Statement statement = databaseConfiguration.getConnection().createStatement();

        String sql = "SELECT * from project_database.members";
        ResultSet resultSet = statement.executeQuery(sql);

        ArrayList<Member> members = new ArrayList<>();

        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            int age = resultSet.getInt("age");
            Sports preferredSport = resultSet.getString("preferredSport").equals("TENNIS") ? Sports.TENNIS : Sports.FOOTBALL;
            int membershipTime = resultSet.getInt("membershipTime");

            Member member = new Member(id, firstName, lastName, age, preferredSport, membershipTime);
            members.add(member);
        }

        resultSet.close();
        statement.close();

        return members;

    }

    public void addMemberDB(Member member) throws SQLException{
        try{
            String sql = "INSERT INTO members (id, firstName, lastName, age, preferredSport, membershipTime) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = databaseConfiguration.getConnection().prepareStatement(sql);

            statement.setInt(1, member.getId());
            statement.setString(2, member.getFirstName());
            statement.setString(3, member.getLastName());
            statement.setInt(4, member.getAge());
            statement.setString(5, member.getPreferredSport().toString());
            statement.setInt(6, member.getMembershipTime());

            statement.executeUpdate();
            statement.close();

            System.out.println("Member added successfully");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteMemberDB(int id) throws SQLException{
        try {
            String sql = "DELETE FROM members WHERE id = ?";
            PreparedStatement statement = databaseConfiguration.getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
            statement.close();
            System.out.println("Member deleted successfully");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateMemberDB(Member member) throws SQLException {
        try {
            String sql = "UPDATE members set firstName = ?, lastName = ?, age = ?, preferredSport = ?, membershipTime = ? where ID = ?";
            PreparedStatement statement = databaseConfiguration.getConnection().prepareStatement(sql);

            statement.setString(1, member.getFirstName());
            statement.setString(2, member.getLastName());
            statement.setInt(3, member.getAge());
            statement.setString(4, member.getPreferredSport().toString());
            statement.setInt(5, member.getMembershipTime());
            statement.setInt(6, member.getId());


            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if (rowsUpdated > 0) {
                System.out.println("Member updated successfully");
            } else {
                System.out.println("No member found with the provided ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
