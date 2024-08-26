package shape;

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void print() {
        System.out.println("Hình chữ nhật");
        System.out.println("Chu vi:"+getPerimeter());
        System.out.println("Diện tích: "+getArear());
    }

    @Override
    public double getPerimeter() {
        return ((length+width)*2);
    }

    @Override
    public double getArear() {
        return (length*width);
    }
}
