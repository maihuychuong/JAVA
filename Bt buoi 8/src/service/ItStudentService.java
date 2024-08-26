package service;

import entities.ItStudent;

import java.util.Scanner;

public class ItStudentService {
    public ItStudent inputItStudent(Scanner scanner) {
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập điểm HTML: ");
        double html = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập điểm CSS: ");
        double css = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập điểm JAVA: ");
        double java = Double.parseDouble(scanner.nextLine());
        return new ItStudent(name, "Công nghệ thông tin", html, css, java);
    }
}
