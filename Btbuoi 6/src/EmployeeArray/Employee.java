package EmployeeArray;

public class Employee extends Person {
    private double experience;
    private String placeWork;

    public Employee(int id, String name, String address, int age, double experience, String placeWork) {
        super(id, name, address, age);
        this.experience = experience;
        this.placeWork = placeWork;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public String getPlaceWork() {
        return placeWork;
    }

    public void setPlaceWork(String placeWork) {
        this.placeWork = placeWork;
    }

    @Override
    public String toString() {
        return  "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", address='" + super.getAddress() + '\'' +
                ", age=" + super.getAge() + '\'' +
                "experience=" + experience + '\'' +
                ", placeWork='" + placeWork + '\'' +
                '}';
    }
}
