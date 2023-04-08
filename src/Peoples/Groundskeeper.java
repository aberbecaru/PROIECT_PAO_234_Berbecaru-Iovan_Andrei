package Peoples;
import Useful.Sports;
import Useful.Shift;

public class Groundskeeper extends Employee {

    private Sports sport;
    private Shift shift;

    public Groundskeeper(String firstName, String lastName, int age, int employedTime, Sports sport, Shift shift) {
        super(firstName, lastName, age, employedTime);
        this.sport = sport;
        this.shift = shift;
    }

    public Sports getSport() {
        return sport;
    }

    public void setSport(Sports sport) {
        this.sport = sport;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }
}
