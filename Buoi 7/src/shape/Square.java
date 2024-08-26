package shape;

public class Square extends Shape{
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void print() {
        System.out.println("Hình vuông");
        System.out.println("Chu vi:"+getPerimeter());
        System.out.println("Diện tích: "+getArear());
    }

    @Override
    public double getPerimeter() {
        return (side*4);
    }

    @Override
    public double getArear() {
        return (side*side);
    }
}
