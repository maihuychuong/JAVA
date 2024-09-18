package polygon.service;

import polygon.entities.Rectangle;
import polygon.entities.Square;

import java.util.Scanner;

public class SquareService implements IPolygon{
    public Square inputInfo(Scanner scanner){
        System.out.println("Nhập độ dài cạnh: ");
        double side = Double.parseDouble(scanner.nextLine());
        return new Square(side);
    }

    @Override
    public void display(Rectangle rectangle, Square square) {
        System.out.println(square);
    }

    @Override
    public void calArea(Rectangle rectangle, Square square) {
        System.out.println("Diện tích là: "+(square.getSide() * square.getSide()));
    }
}
