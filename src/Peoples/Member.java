package Peoples;
import Useful.Sports;

public class Member {

    private String firstName;
    private String lastName;
    private int age;
    private Sports preferredSport;
    private int membershipTime;

    public Member(String firstName, String lastName, int age, Sports preferredSport, int membershipTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.preferredSport = preferredSport;
        this.membershipTime = membershipTime;
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
}
