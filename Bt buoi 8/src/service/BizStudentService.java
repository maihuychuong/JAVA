package service;

import entities.BizStudent;

import java.util.Scanner;

public class BizStudentService {
    public BizStudent inputBizStudent(Scanner scanner) {
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập điểm marketting: ");
        double marketting = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập điểm sales: ");
        double sales = Double.parseDouble(scanner.nextLine());
        return new BizStudent(name, "Kinh doanh", marketting, sales);
    }
}
