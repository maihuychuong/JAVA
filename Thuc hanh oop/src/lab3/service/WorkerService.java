package lab3.service;

import lab3.database.Database;
import lab3.entities.Worker;

import java.util.Scanner;

public class WorkerService {
    public Worker addWorker(Scanner scanner){
        System.out.println("Nhập thông tin công nhân: ");
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập lương: ");
        double salary = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập nơi làm việc: ");
        String workPlace = scanner.nextLine();
        Worker worker = new Worker(name, age, salary, workPlace);
        Database.workers.add(worker);
        return worker;
    }

    public Worker updateSalary(Scanner scanner, boolean increase){
        System.out.println("Nhập id công nhân: ");
        int id = Integer.parseInt(scanner.nextLine());
        Worker worker = findWorkerById(id);
        if(worker != null) {
            System.out.println("Nhập lương mới: ");
            double newSalary = Double.parseDouble(scanner.nextLine());
            if(increase) {
                worker.setSalary(newSalary);
                System.out.println("Lương đã tăng.");
            } else {
                worker.setSalary(newSalary);
                System.out.println("Lương đã giảm.");
            }
        } else {
            System.out.println("K tìm thấy công nhân");
        }
        return worker;
    }

    private Worker findWorkerById(int id) {
        for (Worker worker : Database.workers) {
            if(worker.getId() == id) {
                return worker;
            }
        }
        return null;
    }

    public void displayWorker(){
        for (Worker worker : Database.workers) {
            System.out.println("id=" + worker.getId() +
                    ", name='" + worker.getName() + '\'' +
                    ", age=" + worker.getAge() +
                    ", salary=" + worker.getSalary() +
                    ", workPlace='" + worker.getWorkPlace());
        }
    }
}
