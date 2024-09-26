package kt.service;

import kt.data.Database;
import kt.entities.Student;

import java.util.Scanner;

public class StudentService {
    public void input(Scanner scanner){
        System.out.println("Nhập vào số học sinh muốn nhập: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++){
            System.out.println("Nhập thông tin của học sinh thứ " +(i+1));
            System.out.println("Nhập tên: ");
            String name  = scanner.nextLine();
            System.out.println("Nhập ngày sinh: ");
            String dateOfBrith = scanner.nextLine();
            System.out.println("Nhập quê quán: ");
            String address = scanner.nextLine();
            Student student = new Student(name, dateOfBrith, address);
            Database.students.add(student);
        }
    }
}
