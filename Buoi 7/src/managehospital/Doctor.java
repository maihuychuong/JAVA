package managehospital;

public class Doctor extends Person{
    private String specialty;
    private int numberOfWorkingHours;

    public Doctor(String name, int age, String specialty, int numberOfWorkingHours) {
        super(name, age);
        this.specialty = specialty;
        this.numberOfWorkingHours = numberOfWorkingHours;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getNumberOfWorkingHours() {
        return numberOfWorkingHours;
    }

    public void setNumberOfWorkingHours(int numberOfWorkingHours) {
        this.numberOfWorkingHours = numberOfWorkingHours;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + getName() +
                ", age=" + getAge() +
                "specialty='" + specialty + '\'' +
                ", numberOfWorkingHours=" + numberOfWorkingHours +
                '}';
    }
}
