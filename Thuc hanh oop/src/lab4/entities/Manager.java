package lab4.entities;

public class Manager extends Employee{
    private double responsibilityAllowance;

    public Manager(String name, double salary, double responsibilityAllowance) {
        super(name, salary);
        this.responsibilityAllowance = responsibilityAllowance;
    }

    public double getResponsibilityAllowance() {
        return responsibilityAllowance;
    }

    public void setResponsibilityAllowance(double responsibilityAllowance) {
        this.responsibilityAllowance = responsibilityAllowance;
    }

    @Override
    public double calculateIncome() {
        return getSalary() + responsibilityAllowance;
    }
}
