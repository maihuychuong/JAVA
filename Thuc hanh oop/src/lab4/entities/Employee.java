package lab4.entities;

public abstract class Employee {
    private static int autoId;
    private int id;
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.id = ++autoId;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract double calculateIncome();

    public double calculateTax() {
        double income = calculateIncome();
        if (income < 11000000) {
            return 0;
        } else {
            return income / 10;
        }
    }
}
