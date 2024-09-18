package polygon.service;

import polygon.entities.Rectangle;
import polygon.entities.Square;

import java.util.Scanner;

public class RectangleService implements IPolygon{
    public Rectangle inputInfo(Scanner scanner){
        System.out.println("Nhập chiểu dài: ");
        double length = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập chiểu rộng: ");
        double width = Double.parseDouble(scanner.nextLine());
        return new Rectangle(length, width);
    }

    @Override
    public void display(Rectangle rectangle, Square square) {
        System.out.println(rectangle);
    }

    @Override
    public void calArea(Rectangle rectangle, Square square) {
        System.out.println("Diện tích là: "+(rectangle.getLength() * rectangle.getWidth()));
    }
}
