package m1.service;

import m1.service.entities.Family;

import java.util.Scanner;

public class FamilyService {
    public Family inputFamily(Scanner scanner){
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày sinh: ");
        String dob = scanner.nextLine();
        System.out.println("Nhập việc làm: ");
        String job = scanner.nextLine();
        return new Family(name, dob, job);
    }
}
