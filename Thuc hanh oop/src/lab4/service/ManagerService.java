package lab4.service;

import lab4.database.Database;
import lab4.entities.Employee;
import lab4.entities.Manager;

import java.util.Scanner;

public class ManagerService {
    public Employee inputManagerEmployee(Scanner scanner) {
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập lương: ");
        Double salary = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập lương trách nhiệm: ");
        Double responsibilityAllowance = Double.parseDouble(scanner.nextLine());
        Manager emplyee = new Manager(name, salary, responsibilityAllowance);
        Database.employees.add(emplyee);
        return emplyee;
    }
}
