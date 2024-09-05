package extend_lesson.buoi9.view;

import extend_lesson.buoi9.entities.Student;
import extend_lesson.buoi9.entities.TechMaster;
import extend_lesson.buoi9.service.StudentService;
import extend_lesson.buoi9.service.TechmasterService;

import java.util.List;
import java.util.Scanner;

public class Menu {
    StudentService studentService = new StudentService();
    TechmasterService techmasterService = new TechmasterService();

    public void displayMenu(){
        System.out.println("=========Techmaster Managerment========");
        System.out.println("1. Hiển thị thông tin trung tâm");
        System.out.println("2. Thêm học viên");
        System.out.println("3. Cập nhật học lực");
        System.out.println("4. Xóa học viên");
        System.out.println("5. Stp");
        System.out.println("Mời b lựa chọn: ");

    }

    public void selectMenu(Scanner scanner, TechMaster techMaster, List<Student> students, String name){
        do {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    techmasterService.printInfo(techMaster);
                    break;
                case 2:
                    Student student = studentService.insertStudent(scanner);
                    students.add(student);
                    break;
                case 3:

                    System.out.println("Nhập học lực sửa: ");
                    String newClassify = scanner.nextLine();
                    Student newStudent = new Student(student.getName() , newClassify);
                    students.set(id,newStudent);
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(0);
            }

        } while (true);
    }
}
