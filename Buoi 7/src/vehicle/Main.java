package vehicle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhâp quãng đường: ");
        double distant = Double.parseDouble(scanner.nextLine());
        Bus bus = new Bus(distant);
        Train train = new Train(distant);
        Plane plane = new Plane(distant);
        System.out.println(bus);
        System.out.println(train);
        System.out.println(plane);
    }
}
