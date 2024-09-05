package extend_lesson.buoi9.service;

import extend_lesson.buoi9.entities.Classroom;
import extend_lesson.buoi9.entities.Student;

import java.util.List;
import java.util.Scanner;

public class ClassService {
    StudentService studentService = new StudentService();
    public Classroom insertClass(Scanner scanner, List<Student> students){

        System.out.println("Nhập thông tin môn học: ");
        String subject = scanner.nextLine();
        System.out.println("Mời b nhập thông tin của các học viên: ");
        String choice;
        do {
            Student student = studentService.insertStudent(scanner);
            students.add(student);
            System.out.println("DO u want to continues?(y/N)");
            choice = scanner.nextLine();
        } while (choice.equalsIgnoreCase("Y"));
        return  new Classroom(subject, students);
    }
}
