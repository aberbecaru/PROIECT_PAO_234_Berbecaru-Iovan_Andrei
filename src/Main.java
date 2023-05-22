import Database.CoachDatabase;
import Database.FootballDatabase;
import Database.MemberDatabase;
import Database.SponsorDatabase;
import Grounds.Football;
import Grounds.Ground;
import Grounds.Tennis;
import Peoples.Employee;
import Peoples.Member;
import Peoples.Coach;
import Peoples.Groundskeeper;
import The_Complex.Sponsor;
import java.util.InputMismatchException;

import Service.Audit;
import Service.SportsComplex;
import Singleton.CoachSingleton;
import Singleton.FootballSingleton;
import The_Complex.Sponsor;
import Useful.Lighting;
import Useful.Sports;
import Useful.Surfaces;
import Useful.Exposure;
import Useful.Shift;
import Singleton.MemberSingleton;
import config.DatabaseConfiguration;
import java.util.Scanner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TreeSet;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        Database.MemberDatabase memberDatabase = new MemberDatabase(databaseConfiguration);
        Database.CoachDatabase coachDatabase = new CoachDatabase(databaseConfiguration);
        Database.FootballDatabase footballDatabase = new FootballDatabase(databaseConfiguration);
        Database.SponsorDatabase sponsorDatabase = new SponsorDatabase(databaseConfiguration);
        boolean exit = false;
        while (exit == false){
            System.out.println("------Sports Complex Database Menu----------");
            System.out.println("1. View Members");
            System.out.println("2. Add Member");
            System.out.println("3. Delete Member");
            System.out.println("4. Update Member");
            System.out.println("5. View Coaches");
            System.out.println("6. Add Coach");
            System.out.println("7. Delete Coach");
            System.out.println("8. Update Coach");
            System.out.println("9. View Football Grounds");
            System.out.println("10. Add Football Ground");
            System.out.println("11. Delete Football Ground");
            System.out.println("12. Update Football Ground");
            System.out.println("13. View Sponsors");
            System.out.println("14. Add Sponsor");
            System.out.println("15. Delete Sponsor");
            System.out.println("16. Update Sponsor");
            System.out.println("0. Exit");
            System.out.println("Your option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            try{
                switch (option){
                    case 1:
                        try {
                            ArrayList<Member> members = memberDatabase.readMemberDB();
                            for (Member member : members) {
                                System.out.println(member);
                            }
                        } catch (SQLException e){
                            System.out.println("Error reading members");
                        }
                        break;

                    case 2:
                        try {
                            System.out.println("Enter member details:");
                            System.out.print("ID: ");
                            int memberId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("First Name: ");
                            String firstName = scanner.nextLine();
                            System.out.print("Last Name: ");
                            String lastName = scanner.nextLine();
                            System.out.print("Age: ");
                            int age = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Preferred Sport (FOOTBALL or TENNIS): ");
                            String sportStr = scanner.nextLine();
                            Useful.Sports sport = Useful.Sports.valueOf(sportStr.toUpperCase());
                            System.out.print("Membership Time: ");
                            int membershipTime = scanner.nextInt();
                            scanner.nextLine();

                            Peoples.Member member = new Peoples.Member(memberId, firstName, lastName, age, sport, membershipTime);
                            memberDatabase.addMemberDB(member);
                            break;
                        }
                        catch (SQLException e){
                            System.out.println("Error adding member");
                        }
                        break;

                    case 3:
                        try {
                            System.out.println("Enter member ID to delete: ");
                            int memberId = scanner.nextInt();
                            scanner.nextLine();
                            memberDatabase.deleteMemberDB(memberId);
                            break;
                        }
                        catch (SQLException e){
                            System.out.println("Error deleting member");
                        }
                        break;

                    case 4:
                        try {

                            System.out.println("Enter new member details:");
                            System.out.print("First Name: ");
                            String firstName = scanner.nextLine();
                            System.out.print("Last Name: ");
                            String lastName = scanner.nextLine();
                            System.out.print("Age: ");
                            int age = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Preferred Sport (FOOTBALL or TENNIS): ");
                            String sportStr = scanner.nextLine();
                            Useful.Sports sport = Useful.Sports.valueOf(sportStr.toUpperCase());
                            System.out.print("Membership Time: ");
                            int membershipTime = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter member ID to update: ");
                            int memberId = scanner.nextInt();

                            Peoples.Member member = new Peoples.Member(memberId, firstName, lastName, age, sport, membershipTime);
                            memberDatabase.updateMemberDB(member);
                            break;
                        }
                        catch (SQLException e){
                            System.out.println("Error updating member");
                        }
                        break;

                    case 5:
                        try {
                            ArrayList<Coach> coaches = coachDatabase.readCoachDB();
                            for (Coach coach : coaches) {
                                System.out.println(coach);
                            }
                        } catch (SQLException e){
                            System.out.println("Error reading coaches");
                        }
                        break;

                    case 6:
                        try{
                            System.out.println("Enter coach details:");
                            System.out.print("ID: ");
                            int coachId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("First Name: ");
                            String coachFirstName = scanner.nextLine();
                            System.out.print("Last Name: ");
                            String coachLastName = scanner.nextLine();
                            System.out.print("Age: ");
                            int coachAge = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Employed time: ");
                            int employedTime = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Sport (FOOTBALL or TENNIS):  ");
                            String sportStr = scanner.nextLine();
                            Useful.Sports sport = Useful.Sports.valueOf(sportStr.toUpperCase());
                            System.out.println("Experience: ");
                            int coachExperience = scanner.nextInt();

                            Peoples.Coach coach = new Peoples.Coach(coachId, coachFirstName, coachLastName, coachAge, employedTime, sport, coachExperience);
                            coachDatabase.addCoachDB(coach);
                        }
                        catch (SQLException e){
                            System.out.println("Error adding coach");
                        }
                        break;

                    case 7:
                        try{
                            System.out.println("Enter coach ID to delete: ");
                            int coachId = scanner.nextInt();
                            scanner.nextLine();
                            coachDatabase.deleteCoachDB(coachId);
                        }
                        catch (SQLException e){
                            System.out.println("Error deleting coach");
                        }
                        break;

                    case 8:
                        try{
                            System.out.println("Enter new coach details:");
                            System.out.print("First Name: ");
                            String coachFirstName = scanner.nextLine();
                            System.out.print("Last Name: ");
                            String coachLastName = scanner.nextLine();
                            System.out.print("Age: ");
                            int coachAge = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Employed time: ");
                            int employedTime = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Sport (FOOTBALL or TENNIS):  ");
                            String sportStr = scanner.nextLine();
                            Useful.Sports sport = Useful.Sports.valueOf(sportStr.toUpperCase());
                            System.out.println("Experience: ");
                            int coachExperience = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter coach ID to update: ");
                            int coachId = scanner.nextInt();

                            Peoples.Coach coach = new Peoples.Coach(coachId, coachFirstName, coachLastName, coachAge, employedTime, sport, coachExperience);
                            coachDatabase.updateCoachDB(coach);
                        }
                        catch (SQLException e){
                            System.out.println("Error updating coach");
                        }
                        break;

                    case 9:
                        try{
                            ArrayList<Football> football_grounds = footballDatabase.readFootballDB();
                            for (Football football : football_grounds) {
                                System.out.println(football);
                            }
                        }
                        catch (SQLException e) {
                            System.out.println("Error reading football grounds");
                        }

                        break;

                    case 10:
                        try {
                            System.out.println("Enter football_ground details: ");
                            System.out.print("ID: ");
                            int groundId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Capacity: ");
                            int groundCapacity = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Exposure (OUTDOOR or INDOOR): ");
                            String exposureStr = scanner.nextLine();
                            Useful.Exposure exposure = Useful.Exposure.valueOf(exposureStr.toUpperCase());
                            System.out.println("Lighting (NATURAL or NOCTURNE): ");
                            String lightingStr = scanner.nextLine();
                            Useful.Lighting lighting = Useful.Lighting.valueOf(lightingStr.toUpperCase());
                            System.out.println("Length: ");
                            int groundLength = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Width: ");
                            int groundWidth = scanner.nextInt();
                            scanner.nextLine();

                            Football football_ground = new Football(groundId, groundCapacity, exposure, lighting, groundLength, groundWidth);
                            footballDatabase.addFootballDB(football_ground);
                        }
                        catch (SQLException e){
                            System.out.println("Error adding football ground");
                        }
                        break;

                    case 11:
                        try{
                            System.out.println("Enter football ground ID to delete: ");
                            int groundId = scanner.nextInt();
                            scanner.nextLine();
                            footballDatabase.deleteFootballDB(groundId);
                        }
                        catch (SQLException e){
                            System.out.println("Error deleting football ground");
                        }
                        break;

                    case 12:
                        try{

                            System.out.println("Capacity: ");
                            int groundCapacity = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Exposure (OUTDOOR or INDOOR): ");
                            String exposureStr = scanner.nextLine();
                            Useful.Exposure exposure = Useful.Exposure.valueOf(exposureStr.toUpperCase());
                            System.out.println("Lighting (NATURAL or NOCTURNE): ");
                            String lightingStr = scanner.nextLine();
                            Useful.Lighting lighting = Useful.Lighting.valueOf(lightingStr.toUpperCase());
                            System.out.println("Length: ");
                            int groundLength = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Width: ");
                            int groundWidth = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter football ground ID to update: ");
                            int groundId = scanner.nextInt();

                            Football football_ground = new Football(groundId, groundCapacity, exposure, lighting, groundLength, groundWidth);
                            footballDatabase.updateFootballDB(football_ground);
                        }
                        catch (SQLException e){
                            System.out.println("Error updating football ground");
                        }
                        break;

                    case 13:
                        try{
                            ArrayList<Sponsor> sponsors = sponsorDatabase.readSponsorDB();
                            for (Sponsor sponsor : sponsors) {
                                System.out.println(sponsor);
                            }

                        }
                        catch (SQLException e){
                            System.out.println("Error reading sponsors");
                        }
                        break;

                    case 14:
                        try{
                            System.out.println("Enter sponsor details:");
                            System.out.print("ID: ");
                            int sponsorId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Name: ");
                            String sponsorName = scanner.nextLine();

                            System.out.println("Contact information:");
                            String sponsorContact = scanner.nextLine();
                            System.out.println("Type: ");
                            String sponsorType = scanner.nextLine();
                            System.out.println("Amount: ");
                            int sponsorAmount = scanner.nextInt();

                            Sponsor sponsor = new Sponsor(sponsorId, sponsorName, sponsorContact, sponsorType, sponsorAmount);
                            sponsorDatabase.addSponsorDB(sponsor);
                        }
                        catch (SQLException e){
                            System.out.println("Error adding sponsor");
                        }
                        break;

                    case 15:
                        try{
                            System.out.println("Enter sponsor ID to delete: ");
                            int sponsorId = scanner.nextInt();
                            scanner.nextLine();
                            sponsorDatabase.deleteSponsorDB(sponsorId);
                        }
                        catch (SQLException e){
                            System.out.println("Error deleting sponsor");
                        }
                        break;

                    case 16:
                        try{

                            System.out.print("Name: ");
                            String sponsorName = scanner.nextLine();
                            scanner.nextLine();
                            System.out.println("Contact information:");
                            String sponsorContact = scanner.nextLine();
                            System.out.println("Type: ");
                            String sponsorType = scanner.nextLine();
                            System.out.println("Amount: ");
                            int sponsorAmount = scanner.nextInt();
                            System.out.println("ID: ");
                            int sponsorId = scanner.nextInt();

                            Sponsor sponsor = new Sponsor(sponsorId, sponsorName, sponsorContact, sponsorType, sponsorAmount);
                            sponsorDatabase.updateSponsorDB(sponsor);
                        }
                        catch (SQLException e){
                            System.out.println("Error updating sponsor");
                        }

                        break;

                    case 0:
                        System.out.println("Exiting the application...");
                        exit = true;
                        break;
                        default:
                        System.out.println("Invalid option. Please try again.");
                        break;

                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid option. Please try again.");
                scanner.nextLine();
            }

        }
/*
       SportsComplex sportsComplex1 = new SportsComplex("ProSports", "Stefan cel Mare Street", new ArrayList<>(), new ArrayList<>(), new TreeSet<>(), new ArrayList<>());
       ArrayList<Member> members = new ArrayList<>();
       ArrayList<Coach> coaches = new ArrayList<>();
       ArrayList<Football> football_grounds = new ArrayList<>();


       sportsComplex1.addGround(new Tennis(11, 2, Exposure.OUTDOOR, Lighting.NOCTURNE, Surfaces.CLAY));

       Ground ground2 = (new Tennis(12, 4, Exposure.OUTDOOR, Lighting.NATURAL, Surfaces.GRASS));
       sportsComplex1.addGround(ground2);
       Ground ground3 = (new Football(13, 2, Exposure.OUTDOOR, Lighting.NOCTURNE,  60, 40));
       sportsComplex1.addGround(ground3);
       Ground ground4 = (new Football(14, 4, Exposure.OUTDOOR, Lighting.NOCTURNE,  80, 60));
       sportsComplex1.addGround(ground4);

       football_grounds.add((Football) ground3);
       football_grounds.add((Football) ground4);
       FootballSingleton.getInstance().writeFootballCSV(football_grounds);

       ArrayList<Football>test_football = FootballSingleton.getInstance().readFootballCSV();

         for(Football football : test_football)
              System.out.println(football);

       for(Ground ground : sportsComplex1.getGrounds())
          sportsComplex1.rentCost(ground);

       sportsComplex1.addNocturnetoGround(ground2);
       sportsComplex1.addNocturnetoGround(ground3);

       System.out.println("\n----------------------------------------------");

       Employee employee1 = (new Coach(31,"Ruxandra", "Iftimi", 20, 2, Sports.FOOTBALL, 5));
       Employee employee2 = (new Coach(32,"Rares", "Stefanoiu", 20, 10, Sports.TENNIS, 10));
       Employee employee3 =(new Groundskeeper(33,"Robert", "Barbu", 20, 15, Sports.FOOTBALL, Shift.MORNING));
       Employee employee4 = (new Groundskeeper(34,"Florin", "Georgescu", 40, 20, Sports.TENNIS, Shift.NIGHT));
       Employee employee5 = (new Groundskeeper(35, "Catalin", "Cristian", 40, 20, Sports.TENNIS, Shift.NIGHT));

       coaches.add((Coach) employee1);
       coaches.add((Coach) employee2);

       CoachSingleton.getInstance().writeCoachCSV(coaches);

       ArrayList<Coach> test_coaches = CoachSingleton.getInstance().readCoachCSV();
         for(Coach coach : test_coaches)
              System.out.println(coach);



       sportsComplex1.addEmployee(employee1);
       sportsComplex1.addEmployee(employee2);
       sportsComplex1.addEmployee(employee3);
       sportsComplex1.addEmployee(employee4);

       sportsComplex1.printEmployees();
       System.out.println();
       sportsComplex1.calculateSalary();

       sportsComplex1.removeEmployee(employee1);
       sportsComplex1.removeEmployee(employee5);

       System.out.println("\n----------------------------------------------");


       Member member1 = (new Member(1, "Andrei" , "Berbecaru", 20, Sports.TENNIS, 4));
       sportsComplex1.addMember(member1);
       members.add(member1);

       Member member2 = (new Member(2, "Valenin" , "Maftei", 21, Sports.FOOTBALL, 20));
       Member member3 = (new Member(3, "Daniel" , "Mihai", 22, Sports.FOOTBALL, 7));
       sportsComplex1.addMember(member2);
       sportsComplex1.addMember(member3);
       members.add(member2);
       members.add(member3);



       MemberSingleton.getInstance().writeMemberCSV(members);
       sportsComplex1.addMember(new Member(4, "Liviu" , "Moanta", 24, Sports.TENNIS, 10));


       sportsComplex1.printMembers();
       System.out.println();
       sportsComplex1.calculateMembership(member1);

       ArrayList<Member>test_members = new ArrayList<>();

       test_members = MemberSingleton.getInstance().readMemberCSV();

       for(Member member : test_members)
    	   System.out.println(member.toString());

       System.out.println("\n----------------------------------------------");

       Sponsor sponsor1 = (new Sponsor(51, "Nike", "www.nike.com", "endorsment", 10111));
       Sponsor sponsor2 = (new Sponsor(52, "Adidas", "www.adidas.com", "endorsement", 5002));
       sportsComplex1.addSponsor(sponsor1);
       sportsComplex1.addSponsor(sponsor2);

       sportsComplex1.printSponsors();

*/
    }


}