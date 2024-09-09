package lab3.view;

import lab3.service.WorkerService;

import java.util.Scanner;

public class Menu {
    WorkerService workerService = new WorkerService();
    public void displayMenu(Scanner scanner){
        while (true){
            System.out.println("======= Worker Management =======");
            System.out.println("1. Thêm công nhân.");
            System.out.println("2. Tăng lương.");
            System.out.println("3. Giảm lương.");
            System.out.println("4. Hiển thị thông tin công nhân.");
            System.out.println("5. Thoát.");
            System.out.println("Nhập lựa chọn: ");
            selectMenu(scanner);
        }
    }
    public void selectMenu(Scanner scanner){
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                workerService.addWorker(scanner);
                break;
            case 2:
                workerService.updateSalary(scanner,true);
                break;
            case 3:
                workerService.updateSalary(scanner, false);
                break;
            case 4:
                workerService.displayWorker();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Lựa chọn k hợp lí.");
                break;
        }
    }
}
