package polygon;

import polygon.entities.Rectangle;
import polygon.entities.Square;
import polygon.service.RectangleService;
import polygon.service.SquareService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RectangleService rectangleService = new RectangleService();
        SquareService squareService = new SquareService();
        System.out.println("Nhập thông tin hình chữ nhật: ");
        Rectangle rectangle = rectangleService.inputInfo(scanner);
        System.out.println("Nhập thông tin hình vuông: ");
        Square square = squareService.inputInfo(scanner);
        rectangleService.display(rectangle, square);
        rectangleService.calArea(rectangle, square);
        squareService.display(rectangle, square);
        squareService.calArea(rectangle, square);
    }
}
