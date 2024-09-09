package lab4.service;

import lab4.database.Database;
import lab4.entities.Employee;
import lab4.entities.Manager;
import lab4.entities.MarketingEmployee;

import java.util.Scanner;

public class EmployeeService {
    public void displayEmployeeList() {
        for (Employee employee : Database.employees) {
            System.out.println(" - Id: " +employee.getId()+ " - Name: " + employee.getName() + " - Total income: " + (employee.calculateIncome() - employee.calculateTax()) + " - Tax: " + employee.calculateTax());
        }
    }

    public Employee removeEmployee(Scanner scanner){
        System.out.println("Nhập id nhân viên muốn xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Employee employee = findEmployeeById(id);
        if(employee != null) {
            Database.employees.remove(employee);
        } else {
            System.out.println("K tìm thấy nhân viên");
        }
        return employee;
    }

    public Employee updateEmployee(Scanner scanner){
        System.out.println("Nhập id nhân viên muốn cập nhập: ");
        int id = Integer.parseInt(scanner.nextLine());
        Employee employee = findEmployeeById(id);
        if(employee != null) {
            System.out.println("Nhập tên mới: ");
            String name = scanner.nextLine();
            System.out.println("Nhập lương mới: ");
            Double salary = Double.parseDouble(scanner.nextLine());
            employee.setName(name);
            employee.setSalary(salary);
            if(employee instanceof MarketingEmployee){
                System.out.println("Nhập doanh số bán hàng mới: ");
                Double sales = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập tỉ lệ hoa hồng mới: ");
                Double commissionRate = Double.parseDouble(scanner.nextLine());
                ((MarketingEmployee) employee).setSales(sales);
                ((MarketingEmployee) employee).setCommissionRate(commissionRate);
            } else if (employee instanceof Manager){
                System.out.println("Nhập lương trách nhiệm mới: ");
                Double responsibilityAllowance = Double.parseDouble(scanner.nextLine());
                ((Manager) employee).setResponsibilityAllowance(responsibilityAllowance);
            }
        } else {
            System.out.println("K tìm thấy nhân viên");
        }
        return employee;
    }
    private Employee findEmployeeById(int id) {
        for (Employee employee: Database.employees){
            if(employee.getId() == id){
                return employee;
            }
        }
        return null;
    }
    public Employee displayEmployeeBySalary(Scanner scanner) {
        System.out.println("Nhập lương nhân viên muốn tìm: ");
        Double salary = Double.parseDouble(scanner.nextLine());
        Employee employee = findEmployeeBySalary(salary);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("K tìm thấy nhân viên");
        }
        return employee;
    }
    private Employee findEmployeeBySalary(double salary){
        for (Employee employee: Database.employees){
            if(employee.getSalary() == salary){
                return employee;
            }
        }
        return null;
    }
}
