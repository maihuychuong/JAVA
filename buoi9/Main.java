package extend_lesson.buoi9;

import extend_lesson.buoi9.entities.Student;
import extend_lesson.buoi9.entities.TechMaster;
import extend_lesson.buoi9.service.StudentService;
import extend_lesson.buoi9.service.TechmasterService;
import extend_lesson.buoi9.view.Menu;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TechmasterService techmasterService = new TechmasterService();
        List<Student> students = new ArrayList<>();
        TechMaster techMaster = techmasterService.insertTechmaster(scanner, students);
        Menu menu = new Menu();
        menu.selectMenu(scanner, techMaster, students);

    }
}
