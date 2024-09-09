package lab4.service;

import lab4.database.Database;
import lab4.entities.Employee;
import lab4.entities.MarketingEmployee;

import java.util.Scanner;

public class MarketingEmployeeService {
    public Employee inputMarketingEmployee(Scanner scanner){
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập lương: ");
        Double salary = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập doanh số bán hàng: ");
        Double sales = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập tỉ lệ hoa hồng: ");
        Double commissionRate = Double.parseDouble(scanner.nextLine());
        MarketingEmployee employee = new MarketingEmployee(name, salary, sales, commissionRate);
        Database.employees.add(employee);
        return employee;
    }
}
