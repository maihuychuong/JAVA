package lab4.entities;

public class AdministrativeEmployee extends Employee{
    public AdministrativeEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateIncome() {
        return getSalary();
    }
}
