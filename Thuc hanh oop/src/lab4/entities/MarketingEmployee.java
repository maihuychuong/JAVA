package lab4.entities;

public class MarketingEmployee extends Employee{
    private double sales;
    private double commissionRate;

    public MarketingEmployee(String name, double salary, double sales, double commissionRate) {
        super(name, salary);
        this.sales = sales;
        this.commissionRate = commissionRate;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    @Override
    public double calculateIncome() {
        return getSalary() + (sales * commissionRate);
    }
}
