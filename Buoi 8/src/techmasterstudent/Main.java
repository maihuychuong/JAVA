package techmasterstudent;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sinh viên: ");
        String fullName = scanner.nextLine();
        System.out.println("Nhập ngành: ");
        String fieldOfStudy = scanner.nextLine();
        ITStudent itStudent = new ITStudent( 1,3,4);
        itStudent.print();
    }
}