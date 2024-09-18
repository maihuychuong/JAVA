package studentmanager.service;

import studentmanager.entities.Student;

import java.util.Scanner;

public class StudentService implements Iclassification{
    public Student inputStudent(Scanner scanner){
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập điểm: ");
        double marks = Double.parseDouble(scanner.nextLine());
        return new Student(name, age, marks, classify(marks));
    }
    @Override
    public String classify(double marks) {
        if (marks >= 8){
            return "A";
        } else if (marks < 8 && marks > 6.5) {
            return "B";
        } else {
            return "C";
        }
    }

    @Override
    public void display(Student student) {
        System.out.println(student);
    }
}
