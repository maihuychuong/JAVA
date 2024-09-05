package extend_lesson.buoi9.service;

import extend_lesson.buoi9.entities.Classroom;
import extend_lesson.buoi9.entities.Student;
import extend_lesson.buoi9.entities.TechMaster;

import java.util.List;
import java.util.Scanner;

public class TechmasterService {
    ClassService classService = new ClassService();
    public TechMaster insertTechmaster(Scanner scanner, List<Student> students){
         System.out.println("Mời b nhập thông tin của quản lý: ");
        String manager = scanner.nextLine();
        System.out.println("Mời b nhập thông tin của GV: ");
        String teacher = scanner.nextLine();
        System.out.println("Nhập thông tin của lớp học:");
        Classroom classroom = classService.insertClass(scanner, students);
        return new TechMaster(manager, teacher, classroom);
    }

    public void printInfo(TechMaster techMaster){
        System.out.println(techMaster);
    }
}
