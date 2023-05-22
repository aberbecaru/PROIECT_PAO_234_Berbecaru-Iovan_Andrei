package Peoples;
import Useful.Sports;
import java.util.function.Function;

public class Member {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private Sports preferredSport;
    private int membershipTime;

    public Member(int id, String firstName, String lastName, int age, Sports preferredSport, int membershipTime) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.preferredSport = preferredSport;
        this.membershipTime = membershipTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sports getPreferredSport() {
        return preferredSport;
    }

    public void setPreferredSport(Sports preferredSport) {
        this.preferredSport = preferredSport;
    }

    public int getMembershipTime() {
        return membershipTime;
    }

    public void setMembershipTime(int membershipTime) {
        this.membershipTime = membershipTime;
    }

    @Override
    public String toString() {
        return "Member{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", preferredSport=" + preferredSport +
                ", membershipTime=" + membershipTime +
                '}';
    }

    public String toCSV(){
        return id + "," + firstName + "," + lastName + "," + age + "," + preferredSport + "," + membershipTime;
    }
}
