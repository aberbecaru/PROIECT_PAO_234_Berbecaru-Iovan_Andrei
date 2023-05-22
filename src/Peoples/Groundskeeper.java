package Peoples;
import Useful.Sports;
import Useful.Shift;

import java.util.function.Function;

public class Groundskeeper extends Employee {

    private Sports sport;
    private Shift shift;

    public Groundskeeper(int id, String firstName, String lastName, int age, int employedTime, Sports sport, Shift shift) {
        super(id, firstName, lastName, age, employedTime);
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

    Function<String[], Groundskeeper> mapToGroundskeeper = (data) -> {
        int id = Integer.parseInt(data[0]);
        String firstName = data[1];
        String lastName = data[2];
        int age = Integer.parseInt(data[3]);
        int employedTime = Integer.parseInt(data[4]);
        Sports sport = Sports.valueOf(data[5]);
        Shift shift = Shift.valueOf(data[6]);

        return new Groundskeeper(id, firstName, lastName, age, employedTime, sport, shift);
    };
}
