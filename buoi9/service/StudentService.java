package extend_lesson.buoi9.service;

import extend_lesson.buoi9.entities.Student;

import java.util.Scanner;

public class StudentService {
    public Student insertStudent(Scanner scanner){
        System.out.println("Mời b nhập tên học viên");
        String name = scanner.nextLine();
        System.out.println("Học lực");
        String classify = scanner.nextLine();
        return  new Student(name, classify);
    }
    public void updateStudent(Scanner scanner){
        System.out.println("Nhập id sinh viên cần cập nhật:");
        int id = Integer.parseInt(scanner.nextLine());
        for (Student student: )
    }
}
