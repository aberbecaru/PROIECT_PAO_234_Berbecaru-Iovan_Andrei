import Grounds.Football;
import Grounds.Ground;
import Grounds.Tennis;
import Peoples.Employee;
import Peoples.Member;
import Peoples.Coach;
import Peoples.Groundskeeper;

import Useful.Lighting;
import Useful.Sports;
import Useful.Surfaces;
import Useful.Exposure;
import Useful.Shift;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

       SportsComplex sportsComplex1 = new SportsComplex("ProSports", "Stefan cel Mare Street", new ArrayList<>(), new ArrayList<>(), new TreeSet<>());

       sportsComplex1.addGround(new Tennis(11, 2, Exposure.OUTDOOR, Lighting.NOCTURNE, Surfaces.CLAY));
       Ground ground2 = (new Tennis(12, 4, Exposure.OUTDOOR, Lighting.NATURAL, Surfaces.GRASS));
       sportsComplex1.addGround(ground2);
       Ground ground3 = (new Football(13, 2, Exposure.OUTDOOR, Lighting.NOCTURNE,  60, 40));
       sportsComplex1.addGround(ground3);
       sportsComplex1.addGround(new Football(14, 4, Exposure.OUTDOOR, Lighting.NOCTURNE,  80, 60));

       for(Ground ground : sportsComplex1.getGrounds())
          sportsComplex1.rentCost(ground);

       sportsComplex1.addNocturnetoGround(ground2);
       sportsComplex1.addNocturnetoGround(ground3);

       System.out.println("\n----------------------------------------------");

       Employee employee1 = (new Coach("Ruxandra", "Iftimi", 20, 2, Sports.FOOTBALL, 5));
       Employee employee2 = (new Coach("Rares", "Stefanoiu", 20, 10, Sports.TENNIS, 10));
       Employee employee3 =(new Groundskeeper("Robert", "Barbu", 20, 15, Sports.FOOTBALL, Shift.MORNING));
       Employee employee4 = (new Groundskeeper("Florin", "Georgescu", 40, 20, Sports.TENNIS, Shift.NIGHT));
       Employee employee5 = (new Groundskeeper("Catalin", "Cristian", 40, 20, Sports.TENNIS, Shift.NIGHT));

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


       Member member1 = (new Member("Andrei" , "Berbecaru", 20, Sports.TENNIS, 4));
       sportsComplex1.addMember(member1);

       sportsComplex1.addMember(new Member("Valenin" , "Maftei", 21, Sports.FOOTBALL, 20));
       sportsComplex1.addMember(new Member("Daniel" , "Mihai", 22, Sports.FOOTBALL, 7));
       sportsComplex1.addMember(new Member("Liviu" , "Moanta", 24, Sports.TENNIS, 10));

       sportsComplex1.printMembers();
       System.out.println();
       sportsComplex1.calculateMembership(member1);


    }
}