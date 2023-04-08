package Peoples;
import Useful.Sports;

public class Coach extends Employee{
    private Sports sport;
    private int experience;

    public Coach(String firstName, String lastName, int age, int employedTime, Sports sport, int experience) {
        super(firstName, lastName, age, employedTime);
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
}
