package Peoples;
import Useful.Sports;

import java.util.function.Function;

public class Coach extends Employee{
    private Sports sport;
    private int experience;

    public Coach(int id, String firstName, String lastName, int age, int employedTime, Sports sport, int experience) {
        super(id, firstName, lastName, age, employedTime);
        this.sport = sport;
        this.experience = experience;
    }

    public Sports getSport() {
        return sport;
    }

    public void setSport(Sports sport) {
        this.sport = sport;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "sport=" + sport +
                ", experience=" + experience +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", employedTime=" + employedTime +
                '}';
    }

    public String toCSV(){
        return id+ "," + firstName + ',' + lastName + ',' + age + ',' + employedTime + ',' + sport + ',' + experience;
    }
}
