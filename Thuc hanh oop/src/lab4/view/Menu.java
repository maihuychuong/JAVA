package lab4.view;

import lab4.database.Database;
import lab4.entities.Employee;
import lab4.entities.Manager;
import lab4.service.AdministrativeEmployeeService;
import lab4.service.EmployeeService;
import lab4.service.ManagerService;
import lab4.service.MarketingEmployeeService;

import java.util.Scanner;

public class Menu {
    AdministrativeEmployeeService administrativeEmployeeService = new AdministrativeEmployeeService();
    MarketingEmployeeService marketingEmployeeService = new MarketingEmployeeService();
    ManagerService managerService = new ManagerService();
    EmployeeService employeeService = new EmployeeService();

    public void displayMenu(Scanner scanner) {
        while (true) {
            System.out.println("======= Employee Management =======");
            System.out.println("1. Nhập và xuất danh sách nhân viên.");
            System.out.println("2. Xóa nhân viên hoặc cập nhật thông tin nhân viên.");
            System.out.println("3. Tìm kiếm nhân viên theo lương.");
            System.out.println("4. Sắp xếp nhân viên theo họ tên và thu nhập.");
            System.out.println("5. Xuất 5 nhân viên có thu nhập cao nhất công ty.");
            System.out.println("6. Thoát.");
            System.out.println("Nhập lựa chọn: ");
            selectMenu(scanner);
        }
    }

    public void selectMenu(Scanner scanner) {
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.println("Chọn loại nhân viên muốn thêm: ");
                System.out.println("1. Nhân viên hành chính.");
                System.out.println("2. Nhân viên tiếp thị.");
                System.out.println("3. Trưởng phòng.");
                int select1 = Integer.parseInt(scanner.nextLine());
                switch (select1) {
                    case 1:
                        administrativeEmployeeService.inputAdministrativeEmployee(scanner);
                        break;
                    case 2:
                        marketingEmployeeService.inputMarketingEmployee(scanner);
                        break;
                    case 3:
                        managerService.inputManagerEmployee(scanner);
                        break;
                }
                employeeService.displayEmployeeList();
                break;
            case 2:
                System.out.println("1. Xóa.");
                System.out.println("2. Cập nhập thông tin nhân viên.");
                int select2 = Integer.parseInt(scanner.nextLine());
                switch (select2) {
                    case 1:
                        employeeService.removeEmployee(scanner);
                        break;
                    case 2:
                        employeeService.updateEmployee(scanner);
                        break;
                }
                break;
            case 3:
                employeeService.displayEmployeeBySalary(scanner);
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Lựa chọn k hợp lí.");
                break;
        }
    }
}
