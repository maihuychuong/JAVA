package lab4.service;

import lab4.database.Database;
import lab4.entities.AdministrativeEmployee;
import lab4.entities.Employee;

import java.util.Scanner;

public class AdministrativeEmployeeService {
    public Employee inputAdministrativeEmployee(Scanner scanner){
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập lương: ");
        Double salary = Double.parseDouble(scanner.nextLine());
        AdministrativeEmployee employee = new AdministrativeEmployee(name, salary);
        Database.employees.add(employee);
        return employee;
    }
}
