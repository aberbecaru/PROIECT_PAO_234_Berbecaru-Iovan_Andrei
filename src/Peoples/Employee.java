package Peoples;

public abstract class Employee implements Comparable<Employee> {

    protected int id;
    protected String firstName;
    protected String lastName;
    protected int age;

    protected int employedTime;

    public Employee(int id, String firstName, String lastName, int age, int employedTime) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.employedTime = employedTime;
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

    public int getEmployedTime() {
        return employedTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmployedTime(int employedTime) {
        this.employedTime = employedTime;
    }

    @Override
    public int compareTo(Employee o) {

        int lastNameCompare = this.lastName.compareTo(o.lastName);
        if(lastNameCompare != 0)
            return lastNameCompare;
        else
            return this.firstName.compareTo(o.firstName);
    }
}
