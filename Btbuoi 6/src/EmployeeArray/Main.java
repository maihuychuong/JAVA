package EmployeeArray;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhâp số nhân viên muốn nhập: ");
        int n = Integer.parseInt(scanner.nextLine());
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập thông tin nhân viên thứ " + (i + 1) + ":");
            System.out.print("Id: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Tên: ");
            String name = scanner.nextLine();
            System.out.print("Địa chỉ: ");
            String address = scanner.nextLine();
            System.out.print("Tuổi: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Kinh nghiệm làm việc: ");
            double experience = Double.parseDouble(scanner.nextLine());
            System.out.print("Nơi làm việc: ");
            String placeWork = scanner.nextLine();
            employees[i] = new Employee(id, name, address, age, experience, placeWork);
        }
        System.out.println("\nThông tin nhân viên:");
        for (int i = 0; i < n; i++) {
            System.out.println("Nhân viên thứ "+(i + 1)+":"+employees[i]);
        }
    }
}
