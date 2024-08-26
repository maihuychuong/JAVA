package entities;

public class BizStudent extends TechmasterStudent {
    private double marketing;
    private double sales;

    public double getMarketing() {
        return marketing;
    }

    public void setMarketing(double marketing) {
        this.marketing = marketing;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public BizStudent(String fullName, String major, double marketing, double sales) {
        super(fullName, major);
        this.marketing = marketing;
        this.sales = sales;
    }

    @Override
    public double getPoint() {
        return (2 * marketing + sales) / 3;
    }

    @Override
    public String toString() {
        return  "Name=" + getFullName()+
                ", Marketing=" + marketing +
                ", Sales=" + sales +
                ", Point=" + getPoint() +
                ", Classify=" + classify() +
                '}';
    }
}
