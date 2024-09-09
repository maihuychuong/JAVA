package lab2;

import lab2.entities.Student;
import lab2.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();
        List<Student> students = new ArrayList<>();
        System.out.println("Nhập số học sinh: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i<n ; i++){
            System.out.println("Nhập thông tin học sinh "+(i+1)+" :");
            Student student = studentService.studentInput(scanner);
            students.add(student);
        }
        System.out.println(students);
    }
}