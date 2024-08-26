package techmasterstudent;

public class BizStudent extends TechMasterStudent{
    private double marketting;
    public double sales;

    public BizStudent(double marketting, double sales) {
        this.marketting = marketting;
        this.sales = sales;
    }

    @Override
    public double getScore() {
        return (2*marketting + sales)/3 ;
    }

    public double getMarketting() {
        return marketting;
    }

    public void setMarketting(double marketting) {
        this.marketting = marketting;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }
}
