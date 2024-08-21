package BT2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin nhân viên: ");
        int id = Integer.parseInt(scanner.nextLine());
        String name = scanner.nextLine();
        String address = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        double experience = Double.parseDouble(scanner.nextLine());
        String placeWork = scanner.nextLine();
        Employee employee = new Employee(id, name, address, age, experience, placeWork);
        System.out.println(employee);
    }
}
