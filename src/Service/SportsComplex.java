package Service;

import Grounds.Football;
import Grounds.Ground;
import Grounds.Tennis;
import Peoples.Employee;
import Peoples.Member;
import Peoples.Coach;
import Peoples.Groundskeeper;
import Singleton.SponsorSingleton;
import The_Complex.Sponsor;
import Useful.Lighting;
import Useful.Sports;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;
import Service.Audit;
public class SportsComplex {

    private String name;
    private String address;
    private ArrayList<Ground> grounds;

    private ArrayList<Member> members;

    private SortedSet<Employee> employees;

   private ArrayList<Sponsor> sponsors;

    public SportsComplex(String name, String address, ArrayList<Ground> grounds, ArrayList<Member> members, SortedSet<Employee> employees, ArrayList<Sponsor> sponsors){
        this.name = name;
        this.address = address;
        this.grounds = grounds;
        this.members = members;
        this.employees = new TreeSet<Employee>();
        this.sponsors = sponsors;
    }

    public ArrayList<Ground> getGrounds() {
        return grounds;
    }

    public void setGrounds(ArrayList<Ground> grounds) {
        this.grounds = grounds;
    }

    public void addGround(Ground ground){
        grounds.add(ground);
        Audit.getInstance().write("The ground" + ground.getId() + " was added");
    }

    public void removeGround(Ground ground){
        grounds.remove(ground);
        Audit.getInstance().write("The ground" + ground.getId() + " was added");
    }

    public void rentCost(Ground ground){

        if(ground instanceof Tennis){
            Tennis tennis = (Tennis) ground;
            switch (tennis.getSurface()){
                case CLAY:
                    if(tennis.getLighting() == Lighting.NOCTURNE)
                        System.out.println("The cost of renting this ground is 15$ for 2 hours");
                    else
                        System.out.println("The cost of renting this ground is 10$ for 2 hours");
                    break;
                case GRASS:
                    if(tennis.getLighting() == Lighting.NOCTURNE)
                        System.out.println("The cost of renting this ground is 25$ for 2 hours");
                    else
                        System.out.println("The cost of renting this ground is 20$ for 2 hours");
                    break;
                case HARD:
                    if(tennis.getLighting() == Lighting.NOCTURNE)
                        System.out.println("The cost of renting this ground is 20$ for 2 hours");
                    else
                        System.out.println("The cost of renting this ground is 15$ for 2 hours");
                    break;
            }


        }

        if(ground instanceof Football) {
            double rent = 0.0;
            Football football = (Football) ground;
            rent = football.getLength() + football.getWidth();

            if(football.getLighting() == Lighting.NOCTURNE){
                rent += 20;
                System.out.println("The cost of renting this ground is " + rent + " $ for 2 hours");
            }
            else
                System.out.println("The cost of renting this ground is " + rent + " $ for 2 hours");
        }


    }

    public void addNocturnetoGround(Ground ground){
       if(ground.getLighting() == Lighting.NOCTURNE)
           System.out.println("The ground already has nocturne lighting");
       else{
           grounds.remove(ground);
           ground.setLighting(Lighting.NOCTURNE);
           grounds.add(ground);
       }


    }


    public void addEmployee(Employee employee) {
        employees.add(employee);
        Audit.getInstance().write("The employee " + employee.getLastName() + " " + employee.getFirstName() + " was added");
    }
    public void removeEmployee(Employee employee) {
        if (employee.getEmployedTime() < 4)
            System.out.println("The probation period isn't over yet!");
        else {
            try {
                boolean removed = employees.remove(employee);
                if(!removed)
                    throw new Exception("The employee is not hired to this complex!");
            } catch (Exception e) {
                System.out.println("The employee is not on the list");
            }
        }


    }

    public void printEmployees(){
        System.out.println("The employees are: ");
        for(Employee employee : employees){
            System.out.println("Name: " + employee.getLastName() + " " + employee.getFirstName() + ", Age: " + employee.getAge() + ", Employed time: " + employee.getEmployedTime() + " months");
        }

    }

    public void calculateSalary(){
        for(Employee employee : employees) {


            int salary = 0;
            if (employee instanceof Coach) {
                Coach coach = (Coach) employee;
                salary = 1000 + 100 * coach.getExperience();
                System.out.println("The salary of this coach is " + salary + "$");
            }

            if (employee instanceof Groundskeeper) {
                Groundskeeper groundskeeper = (Groundskeeper) employee;
                if (groundskeeper.getSport() == Sports.FOOTBALL)
                    salary = 800;
                else
                    salary = 700;

                System.out.println("The salary of this groundskeeper is " + salary + "$");
            }
        }


    }

    public void addMember(Member member){
        members.add(member);

    }

    public void removeMember(Member member){
        members.remove(member);

    }

    public void printMembers(){
        for(Member member : members){
            System.out.println("Name: " + member.getLastName() + " " + member.getFirstName() + ", Age: " + member.getAge() + ", Membership time: " + member.getMembershipTime() + " months, Preferred sport: " + member.getPreferredSport());
        }


    }

    public void calculateMembership(Member member){

        int cost = 0;
        int discount = 0;

        if(member.getMembershipTime() >=12)
            discount = 2*12;
        else
            discount = 2 * member.getMembershipTime();


        if(member.getPreferredSport() == Sports.FOOTBALL)
            cost = 110 - discount;

        if(member.getPreferredSport() == Sports.TENNIS)
            cost = 95 - discount;


        System.out.println("The cost of the membership for this member is " + cost + "$ per month");

        Audit.getInstance().write("The cost of the membership for this member is " + cost + "$ per month");
    }


    public void addSponsor(Sponsor sponsor){
        sponsors.add(sponsor);
        SponsorSingleton.getInstance().writeSponsorCSV(sponsors);
    }

    public void printSponsors(){
        ArrayList<Sponsor> test_sponsors = SponsorSingleton.getInstance().readSponsorCSV();
        for(Sponsor sponsor : test_sponsors){
            System.out.println(test_sponsors.toString());
        }
    }


}
